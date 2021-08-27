-- 내 스키마
DROP SCHEMA IF EXISTS java_erp;

-- 내 스키마
CREATE SCHEMA java_erp;

-- 직책
CREATE TABLE java_erp.Title (
	tno   INTEGER     NOT NULL COMMENT '직책번호', -- 직책번호
	tname VARCHAR(50) NOT NULL COMMENT '직책명' -- 직책명
)
COMMENT '직책';

-- 직책
ALTER TABLE java_erp.Title
	ADD CONSTRAINT PK_Title -- 직책 기본키
		PRIMARY KEY (
			tno -- 직책번호
		);

-- 부서
CREATE TABLE java_erp.Department (
	dptno   INTEGER     NOT NULL COMMENT '부서번호', -- 부서번호
	dptname VARCHAR(50) NULL     COMMENT '부서명', -- 부서명
	floor   INTEGER     NULL     COMMENT '위치' -- 위치
)
COMMENT '부서';

-- 부서
ALTER TABLE java_erp.Department
	ADD CONSTRAINT PK_Department -- 부서 기본키
		PRIMARY KEY (
			dptno -- 부서번호
		);

-- 사원
CREATE TABLE java_erp.employee (
	empno   INTEGER     NOT NULL COMMENT '사원번호', -- 사원번호
	empname VARCHAR(50) NULL     COMMENT '사원명', -- 사원명
	title   INTEGER     NULL     COMMENT '직책번호', -- 직책번호
	salary  INTEGER     NULL     COMMENT '급여', -- 급여
	manager INTEGER     NULL     COMMENT '직속상사', -- 직속상사
	dno     INTEGER     NULL     COMMENT '부서번호' -- 부서번호
)
COMMENT '사원';

-- 사원
ALTER TABLE java_erp.employee
	ADD CONSTRAINT PK_employee -- 사원 기본키
		PRIMARY KEY (
			empno -- 사원번호
		);

-- 사원
ALTER TABLE java_erp.employee
	ADD CONSTRAINT FK_Title_TO_employee -- 직책 -> 사원
		FOREIGN KEY (
			title -- 직책번호
		)
		REFERENCES java_erp.Title ( -- 직책
			tno -- 직책번호
		);

-- 사원
ALTER TABLE java_erp.employee
	ADD CONSTRAINT FK_employee_TO_employee -- 사원 -> 사원
		FOREIGN KEY (
			manager -- 직속상사
		)
		REFERENCES java_erp.employee ( -- 사원
			empno -- 사원번호
		);

-- 사원
ALTER TABLE java_erp.employee
	ADD CONSTRAINT FK_Department_TO_employee -- 부서 -> 사원
		FOREIGN KEY (
			dno -- 부서번호
		)
		REFERENCES java_erp.Department ( -- 부서
			dptno -- 부서번호
		);
		
	
-- 사용자 게정
drop user 'user_java_erp'@'localhost';

GRANT ALL  privileges ON java_erp.* TO 'user_java_erp'@'localhost' IDENTIFIED BY 'rootroot';




