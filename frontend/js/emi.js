document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('emi-form');
    const resultBox = document.getElementById('result-box');
    const errorBox = document.getElementById('error-box');

    form.addEventListener('submit', async (e) => {
        e.preventDefault();
        hideBox(resultBox);
        hideBox(errorBox);

        const principal = parseFloat(document.getElementById('principal').value);
        const rateAnnual = parseFloat(document.getElementById('rate').value);
        const tenureMonths = parseInt(document.getElementById('tenure').value, 10);

        try {
            const data = await apiPost('/emi/calculate', { principal, rateAnnual, tenureMonths });
            showResult(resultBox, [
                ['Monthly EMI', data.emi],
                ['Total Interest', data.totalInterest],
                ['Total Payment', data.totalPayment]
            ]);
        } catch (err) {
            showError(errorBox, err.message);
        }
    });
});
