document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('discount-form');
    const resultBox = document.getElementById('result-box');
    const errorBox = document.getElementById('error-box');

    form.addEventListener('submit', async (e) => {
        e.preventDefault();
        hideBox(resultBox);
        hideBox(errorBox);

        const price = parseFloat(document.getElementById('price').value);
        const discountPercent = parseFloat(document.getElementById('discountPercent').value);

        try {
            const data = await apiPost('/discount/calculate', { price, discountPercent });
            showResult(resultBox, [
                ['Discount Amount', data.discountAmount],
                ['Final Price', data.finalPrice]
            ]);
        } catch (err) {
            showError(errorBox, err.message);
        }
    });
});
