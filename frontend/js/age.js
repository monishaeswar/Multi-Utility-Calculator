document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('age-form');
    const resultBox = document.getElementById('result-box');
    const errorBox = document.getElementById('error-box');

    form.addEventListener('submit', async (e) => {
        e.preventDefault();
        hideBox(resultBox);
        hideBox(errorBox);

        const dob = document.getElementById('dob').value;

        try {
            const data = await apiPost('/age/calculate', { dob });
            showResult(resultBox, [
                ['Years', data.years],
                ['Months', data.months],
                ['Days', data.days],
                ['Total Days', data.totalDays]
            ]);
        } catch (err) {
            showError(errorBox, err.message);
        }
    });
});
