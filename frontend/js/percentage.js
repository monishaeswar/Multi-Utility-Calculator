document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('percentage-form');
    const resultBox = document.getElementById('result-box');
    const errorBox = document.getElementById('error-box');

    form.addEventListener('submit', async (e) => {
        e.preventDefault();
        hideBox(resultBox);
        hideBox(errorBox);

        const value = parseFloat(document.getElementById('value').value);
        const percent = parseFloat(document.getElementById('percent').value);
        const mode = document.getElementById('mode').value;

        try {
            const data = await apiPost('/percentage/calculate', { value, percent, mode });
            const rows = Object.entries(data).map(([k, v]) => [
                k.replace(/([A-Z])/g, ' $1').replace(/^./, s => s.toUpperCase()),
                v
            ]);
            showResult(resultBox, rows);
        } catch (err) {
            showError(errorBox, err.message);
        }
    });
});
