INSERT INTO company.person VALUES ('EMP001', 'Tyler','Test','ttest@gmail.com');
INSERT INTO company.person VALUES ('EMP002', 'Joel','Test','jtest@gmail.com');
INSERT INTO company.person VALUES ('EMP003', 'Alex','Test','atest@gmail.com');

INSERT INTO company.position VALUES ('POS001', 'Ceo','Board',120000.00);
INSERT INTO company.position VALUES ('POS002', 'Manager','Management',80000.00);
INSERT INTO company.position VALUES ('POS003', 'Clerk','Staff',40000.00);

INSERT INTO company.person_position VALUES ('EMPPOS001', 'POS001','EMP001',  CURRENT_DATE(), CURRENT_DATE());
INSERT INTO company.person_position VALUES ('EMPPOS002', 'POS002','EMP002',  CURRENT_DATE(), CURRENT_DATE());
INSERT INTO company.person_position VALUES ('EMPPOS003', 'POS003','EMP003',  CURRENT_DATE(), CURRENT_DATE());

