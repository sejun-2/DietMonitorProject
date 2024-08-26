--테이블 생성 코드

CREATE TABLE member(
account_no number,
member_no number,
email VARCHAR2(40 CHAR),
pw VARCHAR2(16 CHAR),
name VARCHAR2(10 CHAR),
nickname VARCHAR2(10 CHAR),
tel VARCHAR2(11 CHAR),
birth DATE,
gender_id NUMBER,
icon_id NUMBER,
created_at DATE,
pregnant_date DATE,
CONSTRAINT pk_member PRIMARY KEY(account_no, member_no)
);

CREATE SEQUENCE account_no_seq
START with 1
INCREMENT by 1
NOCYCLE;

CREATE SEQUENCE log_no_seq
START with 1
INCREMENT by 1
NOCYCLE;

CREATE TABLE gender(
gender_id NUMBER PRIMARY KEY,
gender_name VARCHAR2(60)
);

CREATE TABLE nutrition_standard(
nutrient_id NUMBER,
gender_id NUMBER,
age_min NUMBER,
age_max NUMBER,
intake_rec NUMBER,
intake_max NUMBER
);

CREATE TABLE nutrient(
nutrient_id NUMBER PRIMARY KEY,
nutrient_name VARCHAR2(60),
nutrient_unit VARCHAR2(60)
);

CREATE TABLE daily_intake_rec(
account_no NUMBER,
member_no NUMBER,
nutrient_id NUMBER,
nutrient_rec NUMBER,
CONSTRAINT pk_daily_intake_rec PRIMARY KEY(account_no, member_no, nutrient_id)
);

CREATE TABLE sympton_of_lack(
nutrient_id NUMBER,
nutrient_lack_sympton VARCHAR2(600)
);

CREATE TABLE diet(
log_no NUMBER PRIMARY KEY,
account_no NUMBER,
member_no NUMBER,
save_date DATE,
food_code VARCHAR2(60),
food_intake NUMBER,
kcal NUMBER,
water NUMBER,
protein NUMBER,
fat NUMBER,
batch NUMBER,
carbohydrate NUMBER,
sugars NUMBER,
dietary_fiber NUMBER,
calcium NUMBER,
iron_content NUMBER,
phosphorus NUMBER,
potassium NUMBER,
sodium NUMBER,
vitamin_a NUMBER,
retinol NUMBER,
beta_carotene NUMBER,
thiamine NUMBER,
riboflavin NUMBER,
niacin NUMBER,
vitamin_c NUMBER,
vitamin_d NUMBER,
cholesterol NUMBER,
saturated_fat NUMBER,
trans_fat NUMBER,
state NUMBER
);

-- 데이터 insert문

INSERT INTO gender VALUES(1, '영아');
INSERT INTO gender VALUES(2, '유아');
INSERT INTO gender VALUES(3, '남자');
INSERT INTO gender VALUES(4, '여자');
INSERT INTO gender VALUES(5, '임산부');
INSERT INTO gender VALUES(6, '수유부');

INSERT INTO nutrient VALUES(1, '에너지', 'kcal');
INSERT INTO nutrient VALUES(2, '수분', 'g');
INSERT INTO nutrient VALUES(3, '단백질', 'g');
INSERT INTO nutrient VALUES(4, '지방', 'g');
INSERT INTO nutrient VALUES(5, '탄수화물', 'g');
INSERT INTO nutrient VALUES(6, '당류', 'g');
INSERT INTO nutrient VALUES(7, '식이섬유', 'g');
INSERT INTO nutrient VALUES(8, '칼슘', 'mg');
INSERT INTO nutrient VALUES(9, '철', 'mg');
INSERT INTO nutrient VALUES(10, '인', 'mg');
INSERT INTO nutrient VALUES(11, '칼륨', 'mg');
INSERT INTO nutrient VALUES(12, '나트륨', 'mg');
INSERT INTO nutrient VALUES(13, '비타민A', 'μg RAE');
INSERT INTO nutrient VALUES(14, '레티놀', 'μg');
INSERT INTO nutrient VALUES(15, '베타카로틴', 'μg');
INSERT INTO nutrient VALUES(16, '티아민', 'mg');
INSERT INTO nutrient VALUES(17, '리보플라빈', 'mg');
INSERT INTO nutrient VALUES(18, '니아신', 'mg');
INSERT INTO nutrient VALUES(19, '비타민C', 'mg');
INSERT INTO nutrient VALUES(20, '비타민D', 'μg');
INSERT INTO nutrient VALUES(21, '콜레스테롤', 'mg');
INSERT INTO nutrient VALUES(22, '포화지방산', 'g');
INSERT INTO nutrient VALUES(23, '트랜스지방산', 'g');

-- 식품 통합 SELECT 쿼리문

SELECT
food_code,
food_name,
data_sort_id,
data_sort_name,
food_sort_id,
food_sort_name,
main_category_id,
main_category_name,
rep_food_id,
rep_food_name,
mid_category_id,
mid_category_name,
sub_category_id,
sub_category_name,
min_category_id,
min_category_name,
nut_standard_amount,
kcal,
water,
protein,
fat,
batch,
carbohydrate,
sugars,
dietary_fiber,
calcium,
iron_content,
phosphorus,
potassium,
sodium,
vitamin_a,
retinol,
beta_carotene,
thiamine,
riboflavin,
niacin,
vitamin_c,
vitamin_d,
cholesterol,
saturated_fat,
trans_fat,
source_code,
source_name,
ref_amount_once,
food_weight,
manufacturing_number,
manufacturing_company,
data_generation_method_code,
data_generation_method_name,
TO_CHAR(data_creation_date, 'YYYY-MM-DD') data_creation_date,
TO_CHAR(data_base_date, 'YYYY-MM-DD') data_base_date
FROM food_list_processed
UNION ALL
SELECT
food_code,
food_name,
data_sort_id,
data_sort_name,
food_sort_id,
food_sort_name,
main_category_id,
main_category_name,
rep_food_id,
rep_food_name,
mid_category_id,
mid_category_name,
sub_category_id,
sub_category_name,
min_category_id,
min_category_name,
nut_standard_amount,
kcal,
water,
protein,
fat,
batch,
carbohydrate,
sugars,
dietary_fiber,
calcium,
iron_content,
phosphorus,
potassium,
sodium,
vitamin_a,
retinol,
beta_carotene,
thiamine,
riboflavin,
niacin,
vitamin_c,
vitamin_d,
cholesterol,
saturated_fat,
trans_fat,
source_code,
source_name,
null,
food_weight,
null,
manufacturing_company,
data_generation_method_code,
data_generation_method_name,
TO_CHAR(data_creation_date, 'YYYY-MM-DD') data_creation_date,
TO_CHAR(data_base_date, 'YYYY-MM-DD') data_base_date
FROM food_list_cooked
UNION ALL
SELECT
food_code,
food_name,
data_sort_id,
data_sort_name,
food_sort_id,
food_sort_name,
main_category_id,
main_category_name,
rep_food_id,
rep_food_name,
mid_category_id,
mid_category_name,
sub_category_id,
sub_category_name,
min_category_id,
min_category_name,
nut_standard_amount,
kcal,
water,
protein,
fat,
batch,
carbohydrate,
sugars,
dietary_fiber,
calcium,
iron_content,
phosphorus,
potassium,
sodium,
vitamin_a,
retinol,
beta_carotene,
thiamine,
riboflavin,
niacin,
vitamin_c,
vitamin_d,
cholesterol,
saturated_fat,
trans_fat,
source_code,
source_name,
null,
null,
null,
null,
data_generation_method_code,
data_generation_method_name,
TO_CHAR(data_creation_date, 'YYYY-MM-DD') data_creation_date,
TO_CHAR(data_base_date, 'YYYY-MM-DD') data_base_date
FROM food_list_agriculture
UNION ALL
SELECT
food_code,
food_name,
data_sort_id,
data_sort_name,
food_sort_id,
food_sort_name,
main_category_id,
main_category_name,
rep_food_id,
rep_food_name,
mid_category_id,
mid_category_name,
sub_category_id,
sub_category_name,
min_category_id,
min_category_name,
nut_standard_amount,
kcal,
water,
protein,
fat,
batch,
carbohydrate,
sugars,
dietary_fiber,
calcium,
iron_content,
phosphorus,
potassium,
sodium,
vitamin_a,
retinol,
beta_carotene,
thiamine,
riboflavin,
niacin,
vitamin_c,
vitamin_d,
cholesterol,
saturated_fat,
trans_fat,
source_code,
source_name,
null,
null,
null,
null,
data_generation_method_code,
data_generation_method_name,
TO_CHAR(data_creation_date, 'YYYY-MM-DD') data_creation_date,
TO_CHAR(data_base_date, 'YYYY-MM-DD') data_base_date
FROM food_list_fisheries;