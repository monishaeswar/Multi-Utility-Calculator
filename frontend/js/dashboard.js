document.addEventListener('DOMContentLoaded', () => {

    const totalElement = document.getElementById('total-calculations');
    const emiElement = document.getElementById('emi-count');
    const bmiElement = document.getElementById('bmi-count');
    const financialElement = document.getElementById('financial-count');
    const recentElement = document.getElementById('recent-calculations');


    async function loadDashboard() {

        try {

            const history = await apiGet('/history');

            updateStatistics(history);
            displayRecentCalculations(history);

        } catch (error) {

            recentElement.innerHTML = `
                <p class="error-message">
                    Unable to load dashboard data.
                </p>
            `;

            console.error(error);
        }
    }


    function updateStatistics(history) {

        const total = history.length;

        const emiCount = history.filter(
            item => item.calculatorType === 'EMI'
        ).length;

        const bmiCount = history.filter(
            item => item.calculatorType === 'BMI'
        ).length;


        const financialTypes = [
            'EMI',
            'GST',
            'DISCOUNT',
            'PERCENTAGE'
        ];

        const financialCount = history.filter(
            item => financialTypes.includes(item.calculatorType)
        ).length;


        totalElement.textContent = total;
        emiElement.textContent = emiCount;
        bmiElement.textContent = bmiCount;
        financialElement.textContent = financialCount;
    }


    function displayRecentCalculations(history) {

        if (!history || history.length === 0) {

            recentElement.innerHTML = `
                <div class="empty-dashboard">
                    <p>No calculations yet.</p>
                    <a href="../index.html">
                        Start calculating
                    </a>
                </div>
            `;

            return;
        }


        const recent = history.slice(0, 5);


        recentElement.innerHTML = recent.map(item => {

            const date = new Date(item.createdAt)
                .toLocaleString();


            return `
                <div class="recent-item">

                    <div class="recent-info">

                        <span class="recent-type">
                            ${escapeHtml(item.calculatorType)}
                        </span>

                        <span class="recent-input">
                            ${escapeHtml(item.inputData)}
                        </span>

                    </div>

                    <div class="recent-result">
                        ${escapeHtml(item.resultData)}
                    </div>

                    <div class="recent-date">
                        ${date}
                    </div>

                </div>
            `;

        }).join('');
    }


    function escapeHtml(value) {

        const div = document.createElement('div');

        div.textContent = value ?? '';

        return div.innerHTML;
    }


    loadDashboard();

});