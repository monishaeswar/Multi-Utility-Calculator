document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('basic-form');
    const resultBox = document.getElementById('result-box');
    const errorBox = document.getElementById('error-box');

    form.addEventListener('submit', async (e) => {
        e.preventDefault(); // <-- THIS PREVENTS THE PAGE FROM REFRESHING!

        hideBox(resultBox);
        hideBox(errorBox);

        const a = parseFloat(document.getElementById('a').value);
        const b = parseFloat(document.getElementById('b').value);
        const operation = document.getElementById('operation').value;

        try {
            const data = await apiPost('/basic/calculate', { a, b, operation });
            showResult(resultBox, [['Result', data.result]]);
        } catch (err) {
            showError(errorBox, err.message);
        }
    });
});