document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('bmi-form');
    const resultBox = document.getElementById('result-box');
    const errorBox = document.getElementById('error-box');

    form.addEventListener('submit', async (e) => {
        e.preventDefault();
        hideBox(resultBox);
        hideBox(errorBox);

        const heightCm = parseFloat(document.getElementById('height').value);
        const weightKg = parseFloat(document.getElementById('weight').value);

        try {
            const data = await apiPost('/bmi/calculate', { heightCm, weightKg });
            showResult(resultBox, [
                ['BMI', data.bmi],
                ['Category', data.category]
            ]);
        } catch (err) {
            showError(errorBox, err.message);
        }
    });
});
