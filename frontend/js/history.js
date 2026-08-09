document.addEventListener('DOMContentLoaded', () => {
    const tableBody = document.getElementById('history-body');
    const emptyState = document.getElementById('empty-state');
    const filterSelect = document.getElementById('filter-type');
    const clearAllBtn = document.getElementById('clear-all-btn');
    const errorBox = document.getElementById('error-box');

    async function loadHistory() {
        hideBox(errorBox);
        try {
            const type = filterSelect.value;
            const path = type ? `/history?type=${encodeURIComponent(type)}` : '/history';
            const data = await apiGet(path);
            renderHistory(data);
        } catch (err) {
            showError(errorBox, err.message);
        }
    }

    function renderHistory(items) {
        tableBody.innerHTML = '';
        if (!items || items.length === 0) {
            emptyState.style.display = 'block';
            return;
        }
        emptyState.style.display = 'none';

        items.forEach(item => {
            const tr = document.createElement('tr');
            tr.innerHTML = `
                <td><span class="type-tag">${item.calculatorType}</span></td>
                <td>${escapeHtml(item.inputData)}</td>
                <td>${escapeHtml(item.resultData)}</td>
                <td>${new Date(item.createdAt).toLocaleString()}</td>
                <td><button class="del-btn" data-id="${item.id}">Delete</button></td>
            `;
            tableBody.appendChild(tr);
        });

        document.querySelectorAll('.del-btn').forEach(btn => {
            btn.addEventListener('click', async () => {
                try {
                    await apiDelete(`/history/${btn.dataset.id}`);
                    loadHistory();
                } catch (err) {
                    showError(errorBox, err.message);
                }
            });
        });
    }

    function escapeHtml(str) {
        const div = document.createElement('div');
        div.textContent = str;
        return div.innerHTML;
    }

    filterSelect.addEventListener('change', loadHistory);

    clearAllBtn.addEventListener('click', async () => {
        if (!confirm('Clear all calculation history? This cannot be undone.')) return;
        try {
            await apiDelete('/history');
            loadHistory();
        } catch (err) {
            showError(errorBox, err.message);
        }
    });

    loadHistory();
});
