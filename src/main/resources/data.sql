
INSERT INTO APP_USER(ID,EMAIL_TXT,PASSWORD_TXT,USER_ID_TXT,USER_TYPE_TXT,USERNAME_TXT) VALUES('1','test','test','SaileshK','Admin','Sailesh Kushwaha');

INSERT INTO STUDENT_CLASS(STUDENT_CLASS_ID,STUDENT_CLASS_DESC_TXT,ACTIVE_FLG,STUDENT_CLASS_NAME_TXT) VALUES('1','9A','TRUE','9A');
INSERT INTO STUDENT_CLASS(STUDENT_CLASS_ID,STUDENT_CLASS_DESC_TXT,ACTIVE_FLG,STUDENT_CLASS_NAME_TXT) VALUES('2','10A','TRUE','10A');

INSERT INTO STUDENT(STUDENT_ID,ADDRESS_TXT,ADMISSION_NO_NUM,CELL_NO_TXT,EMAIL_ADDRESS_TXT,END_DT,FATHER_AGE_NUM,FATHER_DOB_DT,FATHER_NAME_TXT,FATHER_PROFESSION_TXT,FATHER_QUALIFICATION_TXT,FIRST_NAME_TXT,GENDER_TXT,LAST_NAME_TXT,MOTHER_AGE_NUM,MOTHER_DOB_DT,MOTHER_NAME_TXT,MOTHER_PROFESSION_TXT,MOTHER_QUALIFICATION_TXT,PHONE_NO_TXT,START_DT,STUDENT_ADHAR_ID,DOB_DT,ACTIVE_FLG, NEW_FLG ) VALUES ('1','1','1','1','1','2018-05-05 00:00:00','1','2018-05-05 00:00:00','1','1','1','1','M','PUNJAB','1','2018-05-05 00:00:00','1','1','140301','1','2018-05-05 00:00:00','1','2018-05-05 00:00:00',true,true);
INSERT INTO STUDENT(STUDENT_ID,ADDRESS_TXT,ADMISSION_NO_NUM,CELL_NO_TXT,EMAIL_ADDRESS_TXT,END_DT,FATHER_AGE_NUM,FATHER_DOB_DT,FATHER_NAME_TXT,FATHER_PROFESSION_TXT,FATHER_QUALIFICATION_TXT,FIRST_NAME_TXT,GENDER_TXT,LAST_NAME_TXT,MOTHER_AGE_NUM,MOTHER_DOB_DT,MOTHER_NAME_TXT,MOTHER_PROFESSION_TXT,MOTHER_QUALIFICATION_TXT,PHONE_NO_TXT,START_DT,STUDENT_ADHAR_ID,DOB_DT,ACTIVE_FLG, NEW_FLG ) VALUES ('2','2','2','2','2','2018-05-05 00:00:00','2','2018-05-05 00:00:00','2','2','2','2','M','PUNJAB','1','2018-05-05 00:00:00','2','2','140301','2','2018-05-05 00:00:00','2','2018-05-05 00:00:00',true,false);
INSERT INTO STUDENT(STUDENT_ID,ADDRESS_TXT,ADMISSION_NO_NUM,CELL_NO_TXT,EMAIL_ADDRESS_TXT,END_DT,FATHER_AGE_NUM,FATHER_DOB_DT,FATHER_NAME_TXT,FATHER_PROFESSION_TXT,FATHER_QUALIFICATION_TXT,FIRST_NAME_TXT,GENDER_TXT,LAST_NAME_TXT,MOTHER_AGE_NUM,MOTHER_DOB_DT,MOTHER_NAME_TXT,MOTHER_PROFESSION_TXT,MOTHER_QUALIFICATION_TXT,PHONE_NO_TXT,START_DT,STUDENT_ADHAR_ID,DOB_DT,ACTIVE_FLG, NEW_FLG ) VALUES ('3','3','3','3','3','2018-05-05 00:00:00','2','2018-05-05 00:00:00','3','3','3','3','M','PUNJAB','1','2018-05-05 00:00:00','3','3','140301','3','2018-05-05 00:00:00','3','2018-05-05 00:00:00',true,false);

INSERT INTO STUDENT_STUDENTCLASS(STUDENT_CLASS_ID,STUDENT_ID ) VALUES('1','1');
INSERT INTO STUDENT_STUDENTCLASS(STUDENT_CLASS_ID,STUDENT_ID ) VALUES('2','2');
INSERT INTO STUDENT_STUDENTCLASS(STUDENT_CLASS_ID,STUDENT_ID ) VALUES('1','3');

INSERT INTO CLASS_FEE_TYPE(FEE_TYPE_ID,FEE_TYPE_DESC_TXT,FEE_TYPE_FREQ_TXT,FEE_TYPE_NAME_TXT) VALUES('1','This is the one time Admission Fee for the student','Y','AdmissionFee'); 
INSERT INTO CLASS_FEE_TYPE(FEE_TYPE_ID,FEE_TYPE_DESC_TXT,FEE_TYPE_FREQ_TXT,FEE_TYPE_NAME_TXT) VALUES('2','This is the one time Tuition Fee for the student','Y','TuitionFee');
INSERT INTO CLASS_FEE_TYPE(FEE_TYPE_ID,FEE_TYPE_DESC_TXT,FEE_TYPE_FREQ_TXT,FEE_TYPE_NAME_TXT) VALUES('3','This is the one time Monthly Fee for the student','M','MonthlyFee');

INSERT INTO CLASS_FEE_PARAMS(CLASS_FEE_PARAMS_ID,CLASS_FEE_TYPE_FEE_TYPE_ID,FEE_AMT) VALUES(1,1,2000);
INSERT INTO CLASS_FEE_PARAMS(CLASS_FEE_PARAMS_ID,CLASS_FEE_TYPE_FEE_TYPE_ID,FEE_AMT) VALUES(2,2,1000);
INSERT INTO CLASS_FEE_PARAMS(CLASS_FEE_PARAMS_ID,CLASS_FEE_TYPE_FEE_TYPE_ID,FEE_AMT) VALUES(3,3,1500);

INSERT INTO CLASS_FEE(CLASS_FEE_ID,FEE_DESC_TXT,FEE_END_DT,FEE_NAME_TXT,FEE_START_DT ) VALUES(1,200,'2018-05-05 00:00:00','9 2018-2019','2018-05-05 00:00:00');

INSERT INTO CLASSFEE_CLASSFEEPARAMS(CLASS_FEE_ID,CLASS_FEE_PARAMS_ID) VALUES(1,1);
INSERT INTO CLASSFEE_CLASSFEEPARAMS(CLASS_FEE_ID,CLASS_FEE_PARAMS_ID) VALUES(1,2);
INSERT INTO CLASSFEE_CLASSFEEPARAMS(CLASS_FEE_ID,CLASS_FEE_PARAMS_ID) VALUES(1,3);

--INSERT INTO STUDENT_FEE(STUDENT_FEE_ID,ACTIVE_FLG,STUDENT_FEE_AMT,CLASS_FEE_ID,STUDENT_ID) VALUES('1','TRUE','2000','1','1');

--INSERT INTO STUDENT_FEE_PARAMS(STUDENT_FEE_PARAMS_ID,PARAMS_NAME_TXT,PARAM_TYPE_TXT,PARAMS_VALUE_TXT) VALUES('1','1','200','200');
--INSERT INTO STUDENT_FEE_PARAMS(STUDENT_FEE_PARAMS_ID,PARAMS_NAME_TXT,PARAM_TYPE_TXT,PARAMS_VALUE_TXT) VALUES('2','2','100','100');

--INSERT INTO STUDENTFEE_STUDENTFEEPARAMS(STUDENT_FEE_ID,STUDENT_FEE_PARAMS_ID) VALUES(1,1);
--INSERT INTO STUDENTFEE_STUDENTFEEPARAMS(STUDENT_FEE_ID,STUDENT_FEE_PARAMS_ID) VALUES(1,2); 

--INSERT INTO STUDENT_FEE_PAYMENT_HISTORY(STUDENT_FEE_PAYMENT_ID,PAYMENT_STATUS_TXT,PAYMENT_DT,STUDENT_FEE_PAYMENT_AMT ,STUDENT_ID,STUDENT_FEE_ID ) VALUES(1,'ACTIVE','2015-05-05',	2000,1,1);
--INSERT INTO STUDENT_FEE_PAYMENT_HISTORY(STUDENT_FEE_PAYMENT_ID,PAYMENT_STATUS_TXT,PAYMENT_DT,STUDENT_FEE_PAYMENT_AMT,STUDENT_ID,STUDENT_FEE_ID ) VALUES(2,'ACTIVE','2015-05-05',	1000,1,1);

--INSERT INTO STUDENT_FEE_STUDENT_PAYMENT_HISTORIES(STUDENT_FEE_STUDENT_FEE_ID,STUDENT_PAYMENT_HISTORIES_STUDENT_FEE_PAYMENT_ID ) VALUES(1,1);
--INSERT INTO STUDENT_FEE_STUDENT_PAYMENT_HISTORIES(STUDENT_FEE_STUDENT_FEE_ID,STUDENT_PAYMENT_HISTORIES_STUDENT_FEE_PAYMENT_ID ) VALUES(1,2);
