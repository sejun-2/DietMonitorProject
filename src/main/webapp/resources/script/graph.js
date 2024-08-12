


function barChart(totalDietData) {
    var ctx = document.getElementById("barCanvas").getContext("2d");

    var data = {
        labels: ["에너지", "물", "단백질", "지방", "회분", "탄수화물", "당", "식이섬유", "칼슘", "철분", "인", "칼륨", "나트륨", "비타민A", "레니놀", 
					"베타카로틴", "티아민", "리보플라빈", "니아신", "비타민C", "비타민D","콜레스테롤","포화지방","트랜스지방"],
        datasets: [		
			{
		            label: "필수영양소",
		            data: [100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,100, 100, 100, 100, 100, 100, 100, 100, 100, 100],
		            backgroundColor: "rgba(255,0,0,0.5)",
		            borderColor: "rgba(255,0,0,0.8)",
		            borderWidth: 1
	        },
			{
					label: "섭취영양소",
		            data: [totalDietData.kcal, totalDietData.water , totalDietData.protein , totalDietData.fat , totalDietData.batch , 
						totalDietData.carbohydrate , totalDietData.sugars , totalDietData.dietaryFiber , totalDietData.calcium , 
						totalDietData.ironContent , totalDietData.phosphorus , totalDietData.potassium , totalDietData.sodium , 
						totalDietData.vitaminA , totalDietData.retinol , totalDietData.betaCarotene , totalDietData.thiamine , 
						totalDietData.riboflavin  , totalDietData.niacin  , totalDietData.vitaminC , totalDietData.vitaminD , 
						totalDietData.cholesterol   , totalDietData.saturatedFat   , totalDietData.transFat],
		            backgroundColor: "rgba(0,0,255,0.5)",
		            borderColor: "rgba(0,0,255,0.8)",
		            borderWidth: 1
            }
			
			]
    };

    var options = {
        responsive: true,
        plugins: {
            legend: {
                display: true
            },
            tooltip: {
                callbacks: {
                    label: function(context) {
                        let label = context.dataset.label || '';
                        if (label) {
                            label += ': ';
                        }
                        if (context.parsed.y !== null) {
                            label += context.parsed.y;
                        }
                        return label;
                    }
                }
            }
        },
        scales: {
            y: {
                beginAtZero: true
            }
        }
    };

    new Chart(ctx, {
        type: 'bar',
        data: data,
        options: options
    });
}

function lineChart(totalDietListMonthSum) {
    var ctx = document.getElementById("lineCanvas").getContext("2d");

    var data = {
        labels: ["월", "화", "수", "목", "금", "토", "일"],
        datasets: [
            {
                label: "필수영양소",
                data: [totalDietListMonthSum.kcal, totalDietListMonthSum.water, totalDietListMonthSum.protein, totalDietListMonthSum.fat, totalDietListMonthSum.batch, totalDietListMonthSum.carbohydrate, totalDietData.sugars],
                backgroundColor: "rgba(220,220,220,0.2)",
                borderColor: "rgba(255,0,0,1)",
                borderWidth: 1
            },
            {
                label: "섭취영양소",
                data: [55, 65, 75, 75, 100, 110, totalDietData.fat],
                backgroundColor: "rgba(151,187,205,0.2)",
                borderColor: "rgba(0,0,255,1)",
                borderWidth: 1
            }
        ]
    };

    var options = {
        responsive: true,
        plugins: {
            legend: {
                position: 'top',
            },
            tooltip: {
                callbacks: {
                    label: function(context) {
                        let label = context.dataset.label || '';
                        if (label) {
                            label += ': ';
                        }
                        if (context.parsed.y !== null) {
                            label += context.parsed.y;
                        }
                        return label;
                    }
                }
            }
        },
        scales: {
            y: {
                beginAtZero: true
            }
        }
    };

    new Chart(ctx, {
        type: 'line',
        data: data,
        options: options
    });
}
