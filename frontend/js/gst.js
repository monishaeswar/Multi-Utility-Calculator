document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('gst-form');
    const resultBox = document.getElementById('result-box');
    const errorBox = document.getElementById('error-box');

    form.addEventListener('submit', async (e) => {
        e.preventDefault();
        hideBox(resultBox);
        hideBox(errorBox);

        const amount = parseFloat(document.getElementById('amount').value);
        const rate = parseFloat(document.getElementById('rate').value);
        const mode = document.querySelector('input[name="mode"]:checked').value;

        try {
            const data = await apiPost('/gst/calculate', { amount, rate, mode });
            const rows = mode === 'ADD'
                ? [['GST Amount', data.gstAmount], ['Total Amount', data.totalAmount]]
                : [['Base Amount', data.baseAmount], ['GST Amount', data.gstAmount]];
            showResult(resultBox, rows);
        } catch (err) {
            showError(errorBox, err.message);
        }
    });
});
