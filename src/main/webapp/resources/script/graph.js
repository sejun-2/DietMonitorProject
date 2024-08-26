

function barChart(grapeData) {	//막대그래프 
	
	var ctx = document.getElementById("barCanvas").getContext("2d");

	var data = {
		labels: ["에너지", "물", "단백질", "지방", "탄수화물", "당", "식이섬유", "칼슘", "철분", "인", "칼륨", "나트륨", "비타민A", "레니놀",
			"베타카로틴", "티아민", "리보플라빈", "니아신", "비타민C", "비타민D", "콜레스테롤", "포화지방", "트랜스지방"],
			//섭취 음식 성분 이름
		datasets: [
			{
				label: "필요영양소",
				data: grapeData[0],
				backgroundColor: "rgba(255,0,0,0.5)",
				borderColor: "rgba(255,0,0,0.8)",
				borderWidth: 1
			},
			{
				label: "섭취영양소",
				data: grapeData[1],
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

	


function lineChart(grapeData) {	// 선그래프
	
	const nutrients = [	//DB에서 받아오는 성분과 비교하여 출력하기 위한 배열
		            'kcal', 'water', 'protein', 'fat', 'carbohydrate', 'sugars',
		            'dietaryFiber', 'calcium', 'ironContent', 'phosphorus', 
		            'potassium', 'sodium', 'vitaminA', 'retinol', 'betaCarotene',
		            'thiamine', 'riboflavin', 'niacin', 'vitaminC', 'vitaminD',
		            'cholesterol', 'saturatedFat', 'transFat'
	];
	
	const nutrientsKorean = [	//그래프 라벨 한글화
			            'kcal', '물', '단백질', '지방', '탄수화물', '당류', '식이섬유', '칼슘', 
						'철분함량', '인', '칼륨', '나트륨', '비타민A', '레티놀', '베타카로틴', '티아민', 
						'리보플라빈', '니아신', '비타민C', '비타민D', '콜레스테롤', '포화지방', '트랜스지방'
		];
	
	
	
	let ctx = [];
	
	for (let i = 0; i < nutrients.length; i++) {	//선그래프 성분별로 가짓수 많큼 출력
		
		ctx.push(document.getElementsByClassName("lineCanvas")[i].getContext("2d"));

		let XLabel = [];	//날짜 출력 배열
		
		let nutrienStandard = [];	//성분별 기준치 출력 배열
		
		let nutrientData = [];	//성분별 추이 데이터 출력
		
		for (let j = 0; j < grapeData[1].length; j++) {
		
			XLabel.push(grapeData[1][j].saveDate);	
			
			nutrienStandard.push(grapeData[0][i]);
			
			nutrientData.push(grapeData[1][j][nutrients[i]]);
		}

		var data = {

			labels: XLabel,

			datasets: [
				{
					label: nutrientsKorean[i]+" 필요영양소",
					data: nutrienStandard,
					backgroundColor: "rgba(220,220,220,0.2)",
					borderColor: "rgba(255,0,0,1)",
					borderWidth: 1
				},
				{
					label: nutrientsKorean[i]+" 섭취영양소",
					data: nutrientData,
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
		
		new Chart(ctx[i], {
				type: 'line',
				data: data,
				options: {
					responsive: true,  // 기본적으로 true로 되어 있지만 명시적으로 설정
		           maintainAspectRatio: false,
				}
		});

	}
	
}	