USE calculator_db;

INSERT INTO calculation_history (calculator_type, input_data, result_data, created_at) VALUES
('BASIC', '{"a":12,"b":8,"operation":"ADD"}', '{"result":20}', NOW()),
('BMI', '{"heightCm":175,"weightKg":70}', '{"bmi":22.86,"category":"Normal"}', NOW()),
('AGE', '{"dob":"2000-05-14"}', '{"years":25,"months":2,"days":23}', NOW()),
('EMI', '{"principal":500000,"rateAnnual":8.5,"tenureMonths":60}', '{"emi":10258.29,"totalInterest":115497.4,"totalPayment":615497.4}', NOW()),
('GST', '{"amount":1000,"rate":18,"mode":"ADD"}', '{"gstAmount":180,"totalAmount":1180}', NOW()),
('PERCENTAGE', '{"value":250,"percent":20,"mode":"OF"}', '{"result":50}', NOW()),
('DISCOUNT', '{"price":2000,"discountPercent":15}', '{"discountAmount":300,"finalPrice":1700}', NOW());
