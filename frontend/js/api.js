/**
 * Shared API client for the Multi-Utility Calculator frontend.
 */
const API_BASE_URL = "https://multi-utility-calculator.onrender.com/api";

async function apiPost(path, body) {
    const res = await fetch(`${API_BASE_URL}${path}`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(body)
    });
    const data = await res.json();
    if (!res.ok || data.success === false) {
        throw new Error(data.message || 'Request failed');
    }
    return data.data;
}

async function apiGet(path) {
    const res = await fetch(`${API_BASE_URL}${path}`);
    const data = await res.json();
    if (!res.ok || data.success === false) {
        throw new Error(data.message || 'Request failed');
    }
    return data.data;
}

async function apiDelete(path) {
    const res = await fetch(`${API_BASE_URL}${path}`, { method: 'DELETE' });
    const data = await res.json();
    if (!res.ok || data.success === false) {
        throw new Error(data.message || 'Request failed');
    }
    return data.data;
}

function showResult(boxEl, rows) {
    boxEl.innerHTML = rows
        .map(([label, value]) => `
            <div class="result-row">
                <span class="label">${label}</span>
                <span class="value">${value}</span>
            </div>
        `).join('');
    boxEl.classList.add('show');
}

function showError(boxEl, message) {
    boxEl.textContent = message;
    boxEl.classList.add('show');
}

function hideBox(boxEl) {
    boxEl.classList.remove('show');
    boxEl.innerHTML = '';
}

// Ensure all functions are exposed globally for your basic.js, age.js, etc.
window.apiPost = apiPost;
window.apiGet = apiGet;
window.apiDelete = apiDelete;
window.showResult = showResult;
window.showError = showError;
window.hideBox = hideBox;