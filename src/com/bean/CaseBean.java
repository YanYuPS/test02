package com.bean;

public class CaseBean {
//	private String 

	private String STAGES_EXECTION="";  //	分期执行
	private String IS_SUIBMIT="";  //	
	private String IS_SUBMIT="";  //	是否提交
	private String IS_SELFEMPLOYED="";  //	是否个体户
	private String SELFEMPLOYED_CODE="";  //	字号
	private String SELFEMPLOYED_CHARTERED_CODE="";  //	营业执照号
	private String SELFEMPLOYED_ADDRESS="";  //	营业地址
	private String CITIZEN_AGE="";  //	公民年龄
	private String IS_PUNISHMENT="";  //	是否作出处罚
	private String SECOND="";  //	一期导入数据
	private String UPDATE_TIME="";  //	数据对接更新时间
	private String LNG="";  //	经度
	private String LAT="";  //	纬度
	private String IS_TRAN="";  //	
	private String CASE_DOCKING_ID="";  //	
	private String CREATE_ID="";  //	创建者ID
	private String SUBMIT_TIME="";  //	提交时间
	private String DELETE_TIME="";  //	删除时间
	private String DOCUMENT_NAME="";  //	
	private String DOCUMENT_PATH="";  //	
	private String IS_MOVE="";  //	
	private String COLLECTIVE_DISCUSS_HOST_POST="";  //	集体讨论主持人职务
	private String COLLECTIVE_DISCUSS_ATTENDER="";  //	集体讨论参加人
	private String IS_TRANSFER="";  //	案件是否移送
	private String TRANSFER_ORGAN="";  //	移送机关
	private String TRANSFER_ORGAN_IS_FILING="";  //	移送机关是否立案
	private String TRANSFER_REASON="";  //	移送理由
	private String ORDERCORRECT_NOTIC_DATE="";  //	责令改正通知书日期
	private String ORDERCORRECT_HOST_RECEIPT_DATE="";  //	责令改正当事人签收日期
	private String ORDERCORRECT_LIMI_CORRECT_DATE="";  //	责令改正限期改正日期
	private String ORDERCORRECT_CONTENT="";  //	责令改正内容
	private String IS_PUNISH_DECISION_EXECUT="";  //	是否行政处罚决定执行
	private String PUNISH_DECISION_EXECUT_DATE="";  //		行政处罚决定执行日期
	private String IS_PARTY_EXECUTION="";  //	是否当事人执行
	private String PARTY_EXECUTION_SITUATION="";  //	当事人执行情况
	private String PARTY_EXECUTION_FINES="";  //	当事人执行罚没款金额
	private String IS_PEOPLECOURT_ENFORCEMENT="";  //	是否人民法院行政强制执行
	private String PEOPLECOURT_ENFORCE_STATUS="";  //	人民法院行政强制执行情况
	private String PEOPLECOURT_ENFORCE_FINES="";  //	人民法院行政强制执行罚没款金额
	private String IS_PEOPLECOURT_ACTUAL_EXEC="";  //	是否人民法院行政实际执行
	private String PEOPLECOURT_ACTUAL_EXEC_STATUS="";  //	人民法院行政实际执行情况
	private String PEOPLECOURT_ACTUAL_EXEC_FINES="";  //	人民法院行政实际执行罚没款金额
	private String IS_ADMINISTRATIVE_REVEIEW="";  //	是否行政复查
	private String IS_PLUS_FINE="";  //	是否加处罚款
	private String PLUS_FINE_AMOUNT="";  //	加处罚款金额
	private String IS_RECONSIDERATION="";  //	是否行政复议0不复议1复议
	private String RECONSIDERATION_DATE="";  //	复议日期
	private String RECONSIDERATION_RESULT="";  //	复议结果
	private String IS_LAWSUIT="";  //	是否行政诉讼0不诉讼1诉讼
	private String LAWSUIT_DATE="";  //	诉讼日期
	private String LAWSUIT_RESULT="";  //	诉讼结果
	private String IS_END_CASE="";  //	是否结案
	private String CLOSED_DATE="";  //	结案日期
	private String CURRENT_STATE="";  //	当前状态
	private String CREATE_DATE="";  //	创建时间
	private String DATA_SOURCE="";  //	数据来源,0系统录入1前置机导入
	private String IS_DELETE="";  //	数据删除标识,0未删除1已删除
	private String FILE_REVIEW_STATUS="";  //	案卷评审状态
	private String CASE_CHECK="";  //	案件抽查者
	private String CASE_CHECK_TIME="";  //	案件抽查时间
	private String CASE_REVOKE_CHECK="";  //	案件撤销抽查者
	private String CASE_REVOKE_CHECK_TIME="";  //	案件撤销抽查时间
	private String DISTRICT_GOV_OFFICE_AUDITOR="";  //	区县政府法制办审核者
	private String DISTRICT_GOV_OFFICE_AUDIT_TIME="";  //	区县政府法制办审核时间
	private String DISTRICT_GOV_OFFICE_AUDIT_STA="";  //	区县政府法制办审核状态
	private String IS_OTHER="";  //	（其他）
	private String OTHER_DETAIL_CONTENT="";  //	其他明细内容
	private String IS_ORDER_CORRECT="";  //	是否责令改正
	private String FILING_NUMBER="";  //	立案号（以下为二期追加字段）
	private String APPROVED_PERSON="";  //	批准人
	private String APPROVED_DATE="";  //	批准日期
	private String CONTACT_PHONE_CITIZEN="";  //	联系电话（公民）
	private String CONTACT_PHONE_LEGALPERSON="";  //	联系电话（法人或其他组织）
	private String INFORMINGBOOK_DELIVERY_DATE="";  //	告知书送达日期
	private String SURVEY_END_DATE="";  //	调查终结日期
	private String IS_ORDERCORRECT_DECISION="";  //	责令改正(处罚决定)
	private String IS_PLOT="";  //	是否有减轻1、从轻2、从重情节3(处罚决定) 0无
	private String IS_ORDERCORRECT_EXECTION="";  //	责令改正(处罚执行)
	private String STAGED_EXECTION="";  //	分期执行(处罚执行)
	private String DELAYED_EXECTION="";  //	延后执行(处罚执行)
	private String CASE_SOURCE="";  //	案件来源（1现场检查2投诉3举报4上级机关交办5其他机关移送6媒体曝光7其他）
	private String CASE_SOURCE_OTHER="";  //	其他(案件来源)
	private String DETAIN_PERMIT_DAYS="";  //	暂扣许可证天数
	private String FILING_DATE="";  //	必填	立案日期
	private String HEARING_DATE="";  //	听证日期
	private String BMBH="";  //	部门编号
	private String UNIFORM_CREDIT_CODE="";  //	统一社会信用代码
	private String HAPPEN_PLACE="";  //	发生地
	private String LEGAL_REVIEW_DATE="";  //	
	private String PARTY_ACTIVE_PERFOR_DATE="";  //	当事人主动履行日期
	private String IS_ORGAN_ENFORCE="";  //	是否行政机关强制执行
	private String ORGAN_ENFORCEMENT_DATE="";  //	行政机关强制执行日期
	private String APPLY_COURT_ENFORCE_DATE="";  //	申请人民法院强制执行日期
	private String COURT_ACTUAL_EXE_DATE="";  //	人民法院实际执行日期
	private String ILLEGAL_FACTS="";  //	违法事实
	private String ILLEGAL_EVIDENCE="";  //	违法证据
	private String RECORDID="";  //	一期案件ID
	private String ORGANIZATION_CODE_TYPE="";  //	机构编号类型
	private String ILLEGAL_EVIDENCE_TYPE="";  //	必填	证据类型（01书证，02物证，03试听资料，04电子数据，05证人证言，06当事人陈述，07鉴定意见，08勘验笔录、现场笔录）
	private String ILLEGAL_DESCRIPT="";  //	证据描述
	private String CORRECT_TYPE="";  //	改正类型(调查取证)
	private String CORRECT_TYPE_DECISION="";  //	改正类型(处罚决定)
	private String CORRECT_TYPE_EXECTION="";  //	改正类型(处罚执行)
	private String CORRECT_STARTDATE="";  //	改正开始日期
	private String CORRECT_ENDDATE="";  //	改正结束日期
	private String CORRECT_STARTDATE_DECISION="";  //	改正开始日期
	private String CORRECT_ENDDATE_DECISION="";  //	改正结束日期
	private String CORRECT_STARTDATE_EXECTION="";  //	改正开始日期
	private String CORRECT_ENDDATE_EXECTION="";  //	改正结束日期
	private String CORRECT_DATE="";  //	改正复查日期
	private String LEGAL_EXAMINA_DATE="";  //	法制审查日期
	private String STARTDATE_WITHHOLD="";  //	开始日期（暂扣许可证）
	private String ENDDATE_WITHHOLD="";  //	结束日期（暂扣许可证）
	private String STARTDATE_DETAIN="";  //	开始日期（行政拘留）
	private String ENDDATE_DETAIN="";  //	结束日期（行政拘留）
	private String POSTPONED_TO_DELAY="";  //	延期至（延期）
	private String APPLY_DATE_DELAY="";  //	申请日期（延期）
	private String APPROVAL_DATE_DELAY="";  //	批准日期（延期）
	private String DEADLINE_STAGE="";  //	最后期限（分期）
	private String APPLY_DATE_STAGE="";  //	申请日期（分期）
	private String APPROVAL_DATE_STAGE="";  //	批准日期（分期）
	private String CLOSED_CASE_INFO="";  //	结案说明
	private String CLOSED_STATE	="";  //必填	结案状态
	private String LEGAL_EXAMINA_RESULT="";  //	法制审核结果
	private String COLLECTIVE_DISCUSSION_RESULT="";  //	集体讨论结果
	private String OTHER_ORGAN_NAME="";  //	其机构负责人
	private String OTHER_ORGAN_PHONE_NUM="";  //	其他机构联系方式
	private String OTHER_ORGAN_COMPANY_NAME="";  //	其他机构名称
	private String OTHER_ORGAN_CODE="";  //	其他机构 组织机构代码
	private String OTHER_ORGAN_ADDRESS="";  //	其他机构地址
	private String ID="";  //   主键
	private String CASE_CODE="";  //	案件编号
	private String SUBJECT_ID="";  //	执法主体ID
	private String DEPARTMENT_ID="";  //	执法部门ID
	private String REGISTRANT="";  //		登记人
	private String ENFORCEMENT_DATE="";  //	执法日期
	private String REGISTRANT_DATE="";  //	登记日期
	private String NAME="";  //	案件名称
	private String PARTY_TYPE="";  //	当事人类型，1公民2法人或其他组织
	private String CITIZEN_NAME="";  //	公民姓名
	private String CITIZEN_SEX="";  //	公民性别
	private String CITIZEN_CARD_TYPE="";  //	公民有效身份证件类型
	private String CITIZEN_CARD_CODE="";  //	公民有效身份证件号码
	private String CITIZEN_COMPANY="";  //	公民单位
	private String CITIZEN_ADDRESS="";  //	公民住址
	private String COMPANY_NAME="";  //	单位名称
	private String PRINCIPAL="";  //	法定代表人或负责人
	private String ORGANIZATION_CODE="";  //	组织机构代码
	private String ADDRESS="";  //	地址
	private String PUNISHMENT_CODE="";  //	行政处罚决定书文号
	private String PUNISHMENT_DATE="";  //	行政处罚决定书日期
	private String PD_SENT_DATE="";  //	行政处罚决定书书送达日期
	private String PP_SENT_DATE="";  //	行政处罚缴款书送达日期
	private String SENT_WAY="";  //	送达方式
	private String IS_WARN="";  //	是否警告0不警告1警告
	private String IS_FINE="";  //	是否罚款0不罚款1罚款
	private String FINE_SUM="";  //	罚款金额
	private String IS_REVOKE_LICENSE="";  //	是否吊销许可证或营业执照
	private String IS_ORDER_CLOSURE="";  //	是否责令停产停业
	private String IS_DTAIN="";  //	是否行政拘留
	private String DTAIN_DAYS="";  //	拘留天数
	private String IS_TD_LICENSE="";  //	是否暂扣许可证或营业执照0不暂扣1暂扣
	private String IS_CONFISCATE="";  //	是否没收违法所得0不没收1没收
	private String CONFISCATE_MONEY="";  //	没收所得金额
	private String IS_CONFIS_PROPERTY="";  //	是否没收非法财物0不没收1没收
	private String CONFISCATE_DETAIL="";  //	没收非法财物明细内容
	private String CONFISCATE_PRO_MON="";  //	没收非法财物金额
	private String IS_FORCE="";  //	是否实施行政强制措施0不实施1实施
	private String IS_LIMIT_FREE="";  //	是否限制公民人身自由0不限制1限制
	private String IS_DISTRESS="";  //	是否查封场所、设施或者财物0不查封1查封
	private String IS_DTAIN_PROPERTY="";  //	是否扣押财物0不扣押1扣押
	private String IS_FRESS="";  //	是否冻结存款、汇款0不冻结1冻结
	private String IS_ORTHER_FORCE="";  //	是否其他行政强制措施0不其他1其他
	private String IS_HEARING="";  //	是否听证0不听证1听证
	private String HEARING_INFORM_DATE="";  //	听证通知日期
	private String HEARING_NOTICE_DATE="";  //	听证公告日期
	private String HEARING_HOLD_DATE="";  //	听证举行日期
	private String HEARING_HOST="";  //	听证主持人
	private String HEARING_PARTICIPANTS="";  //	听证参加人
	private String IS_COLLECTIVE_DISCUSSION="";  //	是否集体讨论
	private String COLLECTIVE_DISCUSSION_DATE="";  //	集体讨论日期
	private String COLLECTIVE_DISCUSS_HOST_NAME="";  //	集体讨论主持人姓名
	
	
	public String getSTAGES_EXECTION() {
		return STAGES_EXECTION;
	}
	public void setSTAGES_EXECTION(String sTAGES_EXECTION) {
		STAGES_EXECTION = sTAGES_EXECTION;
	}
	public String getIS_SUIBMIT() {
		return IS_SUIBMIT;
	}
	public void setIS_SUIBMIT(String iS_SUIBMIT) {
		IS_SUIBMIT = iS_SUIBMIT;
	}
	public String getIS_SUBMIT() {
		return IS_SUBMIT;
	}
	public void setIS_SUBMIT(String iS_SUBMIT) {
		IS_SUBMIT = iS_SUBMIT;
	}
	public String getIS_SELFEMPLOYED() {
		return IS_SELFEMPLOYED;
	}
	public void setIS_SELFEMPLOYED(String iS_SELFEMPLOYED) {
		IS_SELFEMPLOYED = iS_SELFEMPLOYED;
	}
	public String getSELFEMPLOYED_CODE() {
		return SELFEMPLOYED_CODE;
	}
	public void setSELFEMPLOYED_CODE(String sELFEMPLOYED_CODE) {
		SELFEMPLOYED_CODE = sELFEMPLOYED_CODE;
	}
	public String getSELFEMPLOYED_CHARTERED_CODE() {
		return SELFEMPLOYED_CHARTERED_CODE;
	}
	public void setSELFEMPLOYED_CHARTERED_CODE(String sELFEMPLOYED_CHARTERED_CODE) {
		SELFEMPLOYED_CHARTERED_CODE = sELFEMPLOYED_CHARTERED_CODE;
	}
	public String getSELFEMPLOYED_ADDRESS() {
		return SELFEMPLOYED_ADDRESS;
	}
	public void setSELFEMPLOYED_ADDRESS(String sELFEMPLOYED_ADDRESS) {
		SELFEMPLOYED_ADDRESS = sELFEMPLOYED_ADDRESS;
	}
	public String getCITIZEN_AGE() {
		return CITIZEN_AGE;
	}
	public void setCITIZEN_AGE(String cITIZEN_AGE) {
		CITIZEN_AGE = cITIZEN_AGE;
	}
	public String getIS_PUNISHMENT() {
		return IS_PUNISHMENT;
	}
	public void setIS_PUNISHMENT(String iS_PUNISHMENT) {
		IS_PUNISHMENT = iS_PUNISHMENT;
	}
	public String getSECOND() {
		return SECOND;
	}
	public void setSECOND(String sECOND) {
		SECOND = sECOND;
	}
	public String getUPDATE_TIME() {
		return UPDATE_TIME;
	}
	public void setUPDATE_TIME(String uPDATE_TIME) {
		UPDATE_TIME = uPDATE_TIME;
	}
	public String getLNG() {
		return LNG;
	}
	public void setLNG(String lNG) {
		LNG = lNG;
	}
	public String getLAT() {
		return LAT;
	}
	public void setLAT(String lAT) {
		LAT = lAT;
	}
	public String getIS_TRAN() {
		return IS_TRAN;
	}
	public void setIS_TRAN(String iS_TRAN) {
		IS_TRAN = iS_TRAN;
	}
	public String getCASE_DOCKING_ID() {
		return CASE_DOCKING_ID;
	}
	public void setCASE_DOCKING_ID(String cASE_DOCKING_ID) {
		CASE_DOCKING_ID = cASE_DOCKING_ID;
	}
	public String getCREATE_ID() {
		return CREATE_ID;
	}
	public void setCREATE_ID(String cREATE_ID) {
		CREATE_ID = cREATE_ID;
	}
	public String getSUBMIT_TIME() {
		return SUBMIT_TIME;
	}
	public void setSUBMIT_TIME(String sUBMIT_TIME) {
		SUBMIT_TIME = sUBMIT_TIME;
	}
	public String getDELETE_TIME() {
		return DELETE_TIME;
	}
	public void setDELETE_TIME(String dELETE_TIME) {
		DELETE_TIME = dELETE_TIME;
	}
	public String getDOCUMENT_NAME() {
		return DOCUMENT_NAME;
	}
	public void setDOCUMENT_NAME(String dOCUMENT_NAME) {
		DOCUMENT_NAME = dOCUMENT_NAME;
	}
	public String getDOCUMENT_PATH() {
		return DOCUMENT_PATH;
	}
	public void setDOCUMENT_PATH(String dOCUMENT_PATH) {
		DOCUMENT_PATH = dOCUMENT_PATH;
	}
	public String getIS_MOVE() {
		return IS_MOVE;
	}
	public void setIS_MOVE(String iS_MOVE) {
		IS_MOVE = iS_MOVE;
	}
	public String getCOLLECTIVE_DISCUSS_HOST_POST() {
		return COLLECTIVE_DISCUSS_HOST_POST;
	}
	public void setCOLLECTIVE_DISCUSS_HOST_POST(String cOLLECTIVE_DISCUSS_HOST_POST) {
		COLLECTIVE_DISCUSS_HOST_POST = cOLLECTIVE_DISCUSS_HOST_POST;
	}
	public String getCOLLECTIVE_DISCUSS_ATTENDER() {
		return COLLECTIVE_DISCUSS_ATTENDER;
	}
	public void setCOLLECTIVE_DISCUSS_ATTENDER(String cOLLECTIVE_DISCUSS_ATTENDER) {
		COLLECTIVE_DISCUSS_ATTENDER = cOLLECTIVE_DISCUSS_ATTENDER;
	}
	public String getIS_TRANSFER() {
		return IS_TRANSFER;
	}
	public void setIS_TRANSFER(String iS_TRANSFER) {
		IS_TRANSFER = iS_TRANSFER;
	}
	public String getTRANSFER_ORGAN() {
		return TRANSFER_ORGAN;
	}
	public void setTRANSFER_ORGAN(String tRANSFER_ORGAN) {
		TRANSFER_ORGAN = tRANSFER_ORGAN;
	}
	public String getTRANSFER_ORGAN_IS_FILING() {
		return TRANSFER_ORGAN_IS_FILING;
	}
	public void setTRANSFER_ORGAN_IS_FILING(String tRANSFER_ORGAN_IS_FILING) {
		TRANSFER_ORGAN_IS_FILING = tRANSFER_ORGAN_IS_FILING;
	}
	public String getTRANSFER_REASON() {
		return TRANSFER_REASON;
	}
	public void setTRANSFER_REASON(String tRANSFER_REASON) {
		TRANSFER_REASON = tRANSFER_REASON;
	}
	public String getORDERCORRECT_NOTIC_DATE() {
		return ORDERCORRECT_NOTIC_DATE;
	}
	public void setORDERCORRECT_NOTIC_DATE(String oRDERCORRECT_NOTIC_DATE) {
		ORDERCORRECT_NOTIC_DATE = oRDERCORRECT_NOTIC_DATE;
	}
	public String getORDERCORRECT_HOST_RECEIPT_DATE() {
		return ORDERCORRECT_HOST_RECEIPT_DATE;
	}
	public void setORDERCORRECT_HOST_RECEIPT_DATE(String oRDERCORRECT_HOST_RECEIPT_DATE) {
		ORDERCORRECT_HOST_RECEIPT_DATE = oRDERCORRECT_HOST_RECEIPT_DATE;
	}
	public String getORDERCORRECT_LIMI_CORRECT_DATE() {
		return ORDERCORRECT_LIMI_CORRECT_DATE;
	}
	public void setORDERCORRECT_LIMI_CORRECT_DATE(String oRDERCORRECT_LIMI_CORRECT_DATE) {
		ORDERCORRECT_LIMI_CORRECT_DATE = oRDERCORRECT_LIMI_CORRECT_DATE;
	}
	public String getORDERCORRECT_CONTENT() {
		return ORDERCORRECT_CONTENT;
	}
	public void setORDERCORRECT_CONTENT(String oRDERCORRECT_CONTENT) {
		ORDERCORRECT_CONTENT = oRDERCORRECT_CONTENT;
	}
	public String getIS_PUNISH_DECISION_EXECUT() {
		return IS_PUNISH_DECISION_EXECUT;
	}
	public void setIS_PUNISH_DECISION_EXECUT(String iS_PUNISH_DECISION_EXECUT) {
		IS_PUNISH_DECISION_EXECUT = iS_PUNISH_DECISION_EXECUT;
	}
	public String getPUNISH_DECISION_EXECUT_DATE() {
		return PUNISH_DECISION_EXECUT_DATE;
	}
	public void setPUNISH_DECISION_EXECUT_DATE(String pUNISH_DECISION_EXECUT_DATE) {
		PUNISH_DECISION_EXECUT_DATE = pUNISH_DECISION_EXECUT_DATE;
	}
	public String getIS_PARTY_EXECUTION() {
		return IS_PARTY_EXECUTION;
	}
	public void setIS_PARTY_EXECUTION(String iS_PARTY_EXECUTION) {
		IS_PARTY_EXECUTION = iS_PARTY_EXECUTION;
	}
	public String getPARTY_EXECUTION_SITUATION() {
		return PARTY_EXECUTION_SITUATION;
	}
	public void setPARTY_EXECUTION_SITUATION(String pARTY_EXECUTION_SITUATION) {
		PARTY_EXECUTION_SITUATION = pARTY_EXECUTION_SITUATION;
	}
	public String getPARTY_EXECUTION_FINES() {
		return PARTY_EXECUTION_FINES;
	}
	public void setPARTY_EXECUTION_FINES(String pARTY_EXECUTION_FINES) {
		PARTY_EXECUTION_FINES = pARTY_EXECUTION_FINES;
	}
	public String getIS_PEOPLECOURT_ENFORCEMENT() {
		return IS_PEOPLECOURT_ENFORCEMENT;
	}
	public void setIS_PEOPLECOURT_ENFORCEMENT(String iS_PEOPLECOURT_ENFORCEMENT) {
		IS_PEOPLECOURT_ENFORCEMENT = iS_PEOPLECOURT_ENFORCEMENT;
	}
	public String getPEOPLECOURT_ENFORCE_STATUS() {
		return PEOPLECOURT_ENFORCE_STATUS;
	}
	public void setPEOPLECOURT_ENFORCE_STATUS(String pEOPLECOURT_ENFORCE_STATUS) {
		PEOPLECOURT_ENFORCE_STATUS = pEOPLECOURT_ENFORCE_STATUS;
	}
	public String getPEOPLECOURT_ENFORCE_FINES() {
		return PEOPLECOURT_ENFORCE_FINES;
	}
	public void setPEOPLECOURT_ENFORCE_FINES(String pEOPLECOURT_ENFORCE_FINES) {
		PEOPLECOURT_ENFORCE_FINES = pEOPLECOURT_ENFORCE_FINES;
	}
	public String getIS_PEOPLECOURT_ACTUAL_EXEC() {
		return IS_PEOPLECOURT_ACTUAL_EXEC;
	}
	public void setIS_PEOPLECOURT_ACTUAL_EXEC(String iS_PEOPLECOURT_ACTUAL_EXEC) {
		IS_PEOPLECOURT_ACTUAL_EXEC = iS_PEOPLECOURT_ACTUAL_EXEC;
	}
	public String getPEOPLECOURT_ACTUAL_EXEC_STATUS() {
		return PEOPLECOURT_ACTUAL_EXEC_STATUS;
	}
	public void setPEOPLECOURT_ACTUAL_EXEC_STATUS(String pEOPLECOURT_ACTUAL_EXEC_STATUS) {
		PEOPLECOURT_ACTUAL_EXEC_STATUS = pEOPLECOURT_ACTUAL_EXEC_STATUS;
	}
	public String getPEOPLECOURT_ACTUAL_EXEC_FINES() {
		return PEOPLECOURT_ACTUAL_EXEC_FINES;
	}
	public void setPEOPLECOURT_ACTUAL_EXEC_FINES(String pEOPLECOURT_ACTUAL_EXEC_FINES) {
		PEOPLECOURT_ACTUAL_EXEC_FINES = pEOPLECOURT_ACTUAL_EXEC_FINES;
	}
	public String getIS_ADMINISTRATIVE_REVEIEW() {
		return IS_ADMINISTRATIVE_REVEIEW;
	}
	public void setIS_ADMINISTRATIVE_REVEIEW(String iS_ADMINISTRATIVE_REVEIEW) {
		IS_ADMINISTRATIVE_REVEIEW = iS_ADMINISTRATIVE_REVEIEW;
	}
	public String getIS_PLUS_FINE() {
		return IS_PLUS_FINE;
	}
	public void setIS_PLUS_FINE(String iS_PLUS_FINE) {
		IS_PLUS_FINE = iS_PLUS_FINE;
	}
	public String getPLUS_FINE_AMOUNT() {
		return PLUS_FINE_AMOUNT;
	}
	public void setPLUS_FINE_AMOUNT(String pLUS_FINE_AMOUNT) {
		PLUS_FINE_AMOUNT = pLUS_FINE_AMOUNT;
	}
	public String getIS_RECONSIDERATION() {
		return IS_RECONSIDERATION;
	}
	public void setIS_RECONSIDERATION(String iS_RECONSIDERATION) {
		IS_RECONSIDERATION = iS_RECONSIDERATION;
	}
	public String getRECONSIDERATION_DATE() {
		return RECONSIDERATION_DATE;
	}
	public void setRECONSIDERATION_DATE(String rECONSIDERATION_DATE) {
		RECONSIDERATION_DATE = rECONSIDERATION_DATE;
	}
	public String getRECONSIDERATION_RESULT() {
		return RECONSIDERATION_RESULT;
	}
	public void setRECONSIDERATION_RESULT(String rECONSIDERATION_RESULT) {
		RECONSIDERATION_RESULT = rECONSIDERATION_RESULT;
	}
	public String getIS_LAWSUIT() {
		return IS_LAWSUIT;
	}
	public void setIS_LAWSUIT(String iS_LAWSUIT) {
		IS_LAWSUIT = iS_LAWSUIT;
	}
	public String getLAWSUIT_DATE() {
		return LAWSUIT_DATE;
	}
	public void setLAWSUIT_DATE(String lAWSUIT_DATE) {
		LAWSUIT_DATE = lAWSUIT_DATE;
	}
	public String getLAWSUIT_RESULT() {
		return LAWSUIT_RESULT;
	}
	public void setLAWSUIT_RESULT(String lAWSUIT_RESULT) {
		LAWSUIT_RESULT = lAWSUIT_RESULT;
	}
	public String getIS_END_CASE() {
		return IS_END_CASE;
	}
	public void setIS_END_CASE(String iS_END_CASE) {
		IS_END_CASE = iS_END_CASE;
	}
	public String getCLOSED_DATE() {
		return CLOSED_DATE;
	}
	public void setCLOSED_DATE(String cLOSED_DATE) {
		CLOSED_DATE = cLOSED_DATE;
	}
	public String getCURRENT_STATE() {
		return CURRENT_STATE;
	}
	public void setCURRENT_STATE(String cURRENT_STATE) {
		CURRENT_STATE = cURRENT_STATE;
	}
	public String getCREATE_DATE() {
		return CREATE_DATE;
	}
	public void setCREATE_DATE(String cREATE_DATE) {
		CREATE_DATE = cREATE_DATE;
	}
	public String getDATA_SOURCE() {
		return DATA_SOURCE;
	}
	public void setDATA_SOURCE(String dATA_SOURCE) {
		DATA_SOURCE = dATA_SOURCE;
	}
	public String getIS_DELETE() {
		return IS_DELETE;
	}
	public void setIS_DELETE(String iS_DELETE) {
		IS_DELETE = iS_DELETE;
	}
	public String getFILE_REVIEW_STATUS() {
		return FILE_REVIEW_STATUS;
	}
	public void setFILE_REVIEW_STATUS(String fILE_REVIEW_STATUS) {
		FILE_REVIEW_STATUS = fILE_REVIEW_STATUS;
	}
	public String getCASE_CHECK() {
		return CASE_CHECK;
	}
	public void setCASE_CHECK(String cASE_CHECK) {
		CASE_CHECK = cASE_CHECK;
	}
	public String getCASE_CHECK_TIME() {
		return CASE_CHECK_TIME;
	}
	public void setCASE_CHECK_TIME(String cASE_CHECK_TIME) {
		CASE_CHECK_TIME = cASE_CHECK_TIME;
	}
	public String getCASE_REVOKE_CHECK() {
		return CASE_REVOKE_CHECK;
	}
	public void setCASE_REVOKE_CHECK(String cASE_REVOKE_CHECK) {
		CASE_REVOKE_CHECK = cASE_REVOKE_CHECK;
	}
	public String getCASE_REVOKE_CHECK_TIME() {
		return CASE_REVOKE_CHECK_TIME;
	}
	public void setCASE_REVOKE_CHECK_TIME(String cASE_REVOKE_CHECK_TIME) {
		CASE_REVOKE_CHECK_TIME = cASE_REVOKE_CHECK_TIME;
	}
	public String getDISTRICT_GOV_OFFICE_AUDITOR() {
		return DISTRICT_GOV_OFFICE_AUDITOR;
	}
	public void setDISTRICT_GOV_OFFICE_AUDITOR(String dISTRICT_GOV_OFFICE_AUDITOR) {
		DISTRICT_GOV_OFFICE_AUDITOR = dISTRICT_GOV_OFFICE_AUDITOR;
	}
	public String getDISTRICT_GOV_OFFICE_AUDIT_TIME() {
		return DISTRICT_GOV_OFFICE_AUDIT_TIME;
	}
	public void setDISTRICT_GOV_OFFICE_AUDIT_TIME(String dISTRICT_GOV_OFFICE_AUDIT_TIME) {
		DISTRICT_GOV_OFFICE_AUDIT_TIME = dISTRICT_GOV_OFFICE_AUDIT_TIME;
	}
	public String getDISTRICT_GOV_OFFICE_AUDIT_STA() {
		return DISTRICT_GOV_OFFICE_AUDIT_STA;
	}
	public void setDISTRICT_GOV_OFFICE_AUDIT_STA(String dISTRICT_GOV_OFFICE_AUDIT_STA) {
		DISTRICT_GOV_OFFICE_AUDIT_STA = dISTRICT_GOV_OFFICE_AUDIT_STA;
	}
	public String getIS_OTHER() {
		return IS_OTHER;
	}
	public void setIS_OTHER(String iS_OTHER) {
		IS_OTHER = iS_OTHER;
	}
	public String getOTHER_DETAIL_CONTENT() {
		return OTHER_DETAIL_CONTENT;
	}
	public void setOTHER_DETAIL_CONTENT(String oTHER_DETAIL_CONTENT) {
		OTHER_DETAIL_CONTENT = oTHER_DETAIL_CONTENT;
	}
	public String getIS_ORDER_CORRECT() {
		return IS_ORDER_CORRECT;
	}
	public void setIS_ORDER_CORRECT(String iS_ORDER_CORRECT) {
		IS_ORDER_CORRECT = iS_ORDER_CORRECT;
	}
	public String getFILING_NUMBER() {
		return FILING_NUMBER;
	}
	public void setFILING_NUMBER(String fILING_NUMBER) {
		FILING_NUMBER = fILING_NUMBER;
	}
	public String getAPPROVED_PERSON() {
		return APPROVED_PERSON;
	}
	public void setAPPROVED_PERSON(String aPPROVED_PERSON) {
		APPROVED_PERSON = aPPROVED_PERSON;
	}
	public String getAPPROVED_DATE() {
		return APPROVED_DATE;
	}
	public void setAPPROVED_DATE(String aPPROVED_DATE) {
		APPROVED_DATE = aPPROVED_DATE;
	}
	public String getCONTACT_PHONE_CITIZEN() {
		return CONTACT_PHONE_CITIZEN;
	}
	public void setCONTACT_PHONE_CITIZEN(String cONTACT_PHONE_CITIZEN) {
		CONTACT_PHONE_CITIZEN = cONTACT_PHONE_CITIZEN;
	}
	public String getCONTACT_PHONE_LEGALPERSON() {
		return CONTACT_PHONE_LEGALPERSON;
	}
	public void setCONTACT_PHONE_LEGALPERSON(String cONTACT_PHONE_LEGALPERSON) {
		CONTACT_PHONE_LEGALPERSON = cONTACT_PHONE_LEGALPERSON;
	}
	public String getINFORMINGBOOK_DELIVERY_DATE() {
		return INFORMINGBOOK_DELIVERY_DATE;
	}
	public void setINFORMINGBOOK_DELIVERY_DATE(String iNFORMINGBOOK_DELIVERY_DATE) {
		INFORMINGBOOK_DELIVERY_DATE = iNFORMINGBOOK_DELIVERY_DATE;
	}
	public String getSURVEY_END_DATE() {
		return SURVEY_END_DATE;
	}
	public void setSURVEY_END_DATE(String sURVEY_END_DATE) {
		SURVEY_END_DATE = sURVEY_END_DATE;
	}
	public String getIS_ORDERCORRECT_DECISION() {
		return IS_ORDERCORRECT_DECISION;
	}
	public void setIS_ORDERCORRECT_DECISION(String iS_ORDERCORRECT_DECISION) {
		IS_ORDERCORRECT_DECISION = iS_ORDERCORRECT_DECISION;
	}
	public String getIS_PLOT() {
		return IS_PLOT;
	}
	public void setIS_PLOT(String iS_PLOT) {
		IS_PLOT = iS_PLOT;
	}
	public String getIS_ORDERCORRECT_EXECTION() {
		return IS_ORDERCORRECT_EXECTION;
	}
	public void setIS_ORDERCORRECT_EXECTION(String iS_ORDERCORRECT_EXECTION) {
		IS_ORDERCORRECT_EXECTION = iS_ORDERCORRECT_EXECTION;
	}
	public String getSTAGED_EXECTION() {
		return STAGED_EXECTION;
	}
	public void setSTAGED_EXECTION(String sTAGED_EXECTION) {
		STAGED_EXECTION = sTAGED_EXECTION;
	}
	public String getDELAYED_EXECTION() {
		return DELAYED_EXECTION;
	}
	public void setDELAYED_EXECTION(String dELAYED_EXECTION) {
		DELAYED_EXECTION = dELAYED_EXECTION;
	}
	public String getCASE_SOURCE() {
		return CASE_SOURCE;
	}
	public void setCASE_SOURCE(String cASE_SOURCE) {
		CASE_SOURCE = cASE_SOURCE;
	}
	public String getCASE_SOURCE_OTHER() {
		return CASE_SOURCE_OTHER;
	}
	public void setCASE_SOURCE_OTHER(String cASE_SOURCE_OTHER) {
		CASE_SOURCE_OTHER = cASE_SOURCE_OTHER;
	}
	public String getDETAIN_PERMIT_DAYS() {
		return DETAIN_PERMIT_DAYS;
	}
	public void setDETAIN_PERMIT_DAYS(String dETAIN_PERMIT_DAYS) {
		DETAIN_PERMIT_DAYS = dETAIN_PERMIT_DAYS;
	}
	public String getFILING_DATE() {
		return FILING_DATE;
	}
	public void setFILING_DATE(String fILING_DATE) {
		FILING_DATE = fILING_DATE;
	}
	public String getHEARING_DATE() {
		return HEARING_DATE;
	}
	public void setHEARING_DATE(String hEARING_DATE) {
		HEARING_DATE = hEARING_DATE;
	}
	public String getBMBH() {
		return BMBH;
	}
	public void setBMBH(String bMBH) {
		BMBH = bMBH;
	}
	public String getUNIFORM_CREDIT_CODE() {
		return UNIFORM_CREDIT_CODE;
	}
	public void setUNIFORM_CREDIT_CODE(String uNIFORM_CREDIT_CODE) {
		UNIFORM_CREDIT_CODE = uNIFORM_CREDIT_CODE;
	}
	public String getHAPPEN_PLACE() {
		return HAPPEN_PLACE;
	}
	public void setHAPPEN_PLACE(String hAPPEN_PLACE) {
		HAPPEN_PLACE = hAPPEN_PLACE;
	}
	public String getLEGAL_REVIEW_DATE() {
		return LEGAL_REVIEW_DATE;
	}
	public void setLEGAL_REVIEW_DATE(String lEGAL_REVIEW_DATE) {
		LEGAL_REVIEW_DATE = lEGAL_REVIEW_DATE;
	}
	public String getPARTY_ACTIVE_PERFOR_DATE() {
		return PARTY_ACTIVE_PERFOR_DATE;
	}
	public void setPARTY_ACTIVE_PERFOR_DATE(String pARTY_ACTIVE_PERFOR_DATE) {
		PARTY_ACTIVE_PERFOR_DATE = pARTY_ACTIVE_PERFOR_DATE;
	}
	public String getIS_ORGAN_ENFORCE() {
		return IS_ORGAN_ENFORCE;
	}
	public void setIS_ORGAN_ENFORCE(String iS_ORGAN_ENFORCE) {
		IS_ORGAN_ENFORCE = iS_ORGAN_ENFORCE;
	}
	public String getORGAN_ENFORCEMENT_DATE() {
		return ORGAN_ENFORCEMENT_DATE;
	}
	public void setORGAN_ENFORCEMENT_DATE(String oRGAN_ENFORCEMENT_DATE) {
		ORGAN_ENFORCEMENT_DATE = oRGAN_ENFORCEMENT_DATE;
	}
	public String getAPPLY_COURT_ENFORCE_DATE() {
		return APPLY_COURT_ENFORCE_DATE;
	}
	public void setAPPLY_COURT_ENFORCE_DATE(String aPPLY_COURT_ENFORCE_DATE) {
		APPLY_COURT_ENFORCE_DATE = aPPLY_COURT_ENFORCE_DATE;
	}
	public String getCOURT_ACTUAL_EXE_DATE() {
		return COURT_ACTUAL_EXE_DATE;
	}
	public void setCOURT_ACTUAL_EXE_DATE(String cOURT_ACTUAL_EXE_DATE) {
		COURT_ACTUAL_EXE_DATE = cOURT_ACTUAL_EXE_DATE;
	}
	public String getILLEGAL_FACTS() {
		return ILLEGAL_FACTS;
	}
	public void setILLEGAL_FACTS(String iLLEGAL_FACTS) {
		ILLEGAL_FACTS = iLLEGAL_FACTS;
	}
	public String getILLEGAL_EVIDENCE() {
		return ILLEGAL_EVIDENCE;
	}
	public void setILLEGAL_EVIDENCE(String iLLEGAL_EVIDENCE) {
		ILLEGAL_EVIDENCE = iLLEGAL_EVIDENCE;
	}
	public String getRECORDID() {
		return RECORDID;
	}
	public void setRECORDID(String rECORDID) {
		RECORDID = rECORDID;
	}
	public String getORGANIZATION_CODE_TYPE() {
		return ORGANIZATION_CODE_TYPE;
	}
	public void setORGANIZATION_CODE_TYPE(String oRGANIZATION_CODE_TYPE) {
		ORGANIZATION_CODE_TYPE = oRGANIZATION_CODE_TYPE;
	}
	public String getILLEGAL_EVIDENCE_TYPE() {
		return ILLEGAL_EVIDENCE_TYPE;
	}
	public void setILLEGAL_EVIDENCE_TYPE(String iLLEGAL_EVIDENCE_TYPE) {
		ILLEGAL_EVIDENCE_TYPE = iLLEGAL_EVIDENCE_TYPE;
	}
	public String getILLEGAL_DESCRIPT() {
		return ILLEGAL_DESCRIPT;
	}
	public void setILLEGAL_DESCRIPT(String iLLEGAL_DESCRIPT) {
		ILLEGAL_DESCRIPT = iLLEGAL_DESCRIPT;
	}
	public String getCORRECT_TYPE() {
		return CORRECT_TYPE;
	}
	public void setCORRECT_TYPE(String cORRECT_TYPE) {
		CORRECT_TYPE = cORRECT_TYPE;
	}
	public String getCORRECT_TYPE_DECISION() {
		return CORRECT_TYPE_DECISION;
	}
	public void setCORRECT_TYPE_DECISION(String cORRECT_TYPE_DECISION) {
		CORRECT_TYPE_DECISION = cORRECT_TYPE_DECISION;
	}
	public String getCORRECT_TYPE_EXECTION() {
		return CORRECT_TYPE_EXECTION;
	}
	public void setCORRECT_TYPE_EXECTION(String cORRECT_TYPE_EXECTION) {
		CORRECT_TYPE_EXECTION = cORRECT_TYPE_EXECTION;
	}
	public String getCORRECT_STARTDATE() {
		return CORRECT_STARTDATE;
	}
	public void setCORRECT_STARTDATE(String cORRECT_STARTDATE) {
		CORRECT_STARTDATE = cORRECT_STARTDATE;
	}
	public String getCORRECT_ENDDATE() {
		return CORRECT_ENDDATE;
	}
	public void setCORRECT_ENDDATE(String cORRECT_ENDDATE) {
		CORRECT_ENDDATE = cORRECT_ENDDATE;
	}
	public String getCORRECT_STARTDATE_DECISION() {
		return CORRECT_STARTDATE_DECISION;
	}
	public void setCORRECT_STARTDATE_DECISION(String cORRECT_STARTDATE_DECISION) {
		CORRECT_STARTDATE_DECISION = cORRECT_STARTDATE_DECISION;
	}
	public String getCORRECT_ENDDATE_DECISION() {
		return CORRECT_ENDDATE_DECISION;
	}
	public void setCORRECT_ENDDATE_DECISION(String cORRECT_ENDDATE_DECISION) {
		CORRECT_ENDDATE_DECISION = cORRECT_ENDDATE_DECISION;
	}
	public String getCORRECT_STARTDATE_EXECTION() {
		return CORRECT_STARTDATE_EXECTION;
	}
	public void setCORRECT_STARTDATE_EXECTION(String cORRECT_STARTDATE_EXECTION) {
		CORRECT_STARTDATE_EXECTION = cORRECT_STARTDATE_EXECTION;
	}
	public String getCORRECT_ENDDATE_EXECTION() {
		return CORRECT_ENDDATE_EXECTION;
	}
	public void setCORRECT_ENDDATE_EXECTION(String cORRECT_ENDDATE_EXECTION) {
		CORRECT_ENDDATE_EXECTION = cORRECT_ENDDATE_EXECTION;
	}
	public String getCORRECT_DATE() {
		return CORRECT_DATE;
	}
	public void setCORRECT_DATE(String cORRECT_DATE) {
		CORRECT_DATE = cORRECT_DATE;
	}
	public String getLEGAL_EXAMINA_DATE() {
		return LEGAL_EXAMINA_DATE;
	}
	public void setLEGAL_EXAMINA_DATE(String lEGAL_EXAMINA_DATE) {
		LEGAL_EXAMINA_DATE = lEGAL_EXAMINA_DATE;
	}
	public String getSTARTDATE_WITHHOLD() {
		return STARTDATE_WITHHOLD;
	}
	public void setSTARTDATE_WITHHOLD(String sTARTDATE_WITHHOLD) {
		STARTDATE_WITHHOLD = sTARTDATE_WITHHOLD;
	}
	public String getENDDATE_WITHHOLD() {
		return ENDDATE_WITHHOLD;
	}
	public void setENDDATE_WITHHOLD(String eNDDATE_WITHHOLD) {
		ENDDATE_WITHHOLD = eNDDATE_WITHHOLD;
	}
	public String getSTARTDATE_DETAIN() {
		return STARTDATE_DETAIN;
	}
	public void setSTARTDATE_DETAIN(String sTARTDATE_DETAIN) {
		STARTDATE_DETAIN = sTARTDATE_DETAIN;
	}
	public String getENDDATE_DETAIN() {
		return ENDDATE_DETAIN;
	}
	public void setENDDATE_DETAIN(String eNDDATE_DETAIN) {
		ENDDATE_DETAIN = eNDDATE_DETAIN;
	}
	public String getPOSTPONED_TO_DELAY() {
		return POSTPONED_TO_DELAY;
	}
	public void setPOSTPONED_TO_DELAY(String pOSTPONED_TO_DELAY) {
		POSTPONED_TO_DELAY = pOSTPONED_TO_DELAY;
	}
	public String getAPPLY_DATE_DELAY() {
		return APPLY_DATE_DELAY;
	}
	public void setAPPLY_DATE_DELAY(String aPPLY_DATE_DELAY) {
		APPLY_DATE_DELAY = aPPLY_DATE_DELAY;
	}
	public String getAPPROVAL_DATE_DELAY() {
		return APPROVAL_DATE_DELAY;
	}
	public void setAPPROVAL_DATE_DELAY(String aPPROVAL_DATE_DELAY) {
		APPROVAL_DATE_DELAY = aPPROVAL_DATE_DELAY;
	}
	public String getDEADLINE_STAGE() {
		return DEADLINE_STAGE;
	}
	public void setDEADLINE_STAGE(String dEADLINE_STAGE) {
		DEADLINE_STAGE = dEADLINE_STAGE;
	}
	public String getAPPLY_DATE_STAGE() {
		return APPLY_DATE_STAGE;
	}
	public void setAPPLY_DATE_STAGE(String aPPLY_DATE_STAGE) {
		APPLY_DATE_STAGE = aPPLY_DATE_STAGE;
	}
	public String getAPPROVAL_DATE_STAGE() {
		return APPROVAL_DATE_STAGE;
	}
	public void setAPPROVAL_DATE_STAGE(String aPPROVAL_DATE_STAGE) {
		APPROVAL_DATE_STAGE = aPPROVAL_DATE_STAGE;
	}
	public String getCLOSED_CASE_INFO() {
		return CLOSED_CASE_INFO;
	}
	public void setCLOSED_CASE_INFO(String cLOSED_CASE_INFO) {
		CLOSED_CASE_INFO = cLOSED_CASE_INFO;
	}
	public String getCLOSED_STATE() {
		return CLOSED_STATE;
	}
	public void setCLOSED_STATE(String cLOSED_STATE) {
		CLOSED_STATE = cLOSED_STATE;
	}
	public String getLEGAL_EXAMINA_RESULT() {
		return LEGAL_EXAMINA_RESULT;
	}
	public void setLEGAL_EXAMINA_RESULT(String lEGAL_EXAMINA_RESULT) {
		LEGAL_EXAMINA_RESULT = lEGAL_EXAMINA_RESULT;
	}
	public String getCOLLECTIVE_DISCUSSION_RESULT() {
		return COLLECTIVE_DISCUSSION_RESULT;
	}
	public void setCOLLECTIVE_DISCUSSION_RESULT(String cOLLECTIVE_DISCUSSION_RESULT) {
		COLLECTIVE_DISCUSSION_RESULT = cOLLECTIVE_DISCUSSION_RESULT;
	}
	public String getOTHER_ORGAN_NAME() {
		return OTHER_ORGAN_NAME;
	}
	public void setOTHER_ORGAN_NAME(String oTHER_ORGAN_NAME) {
		OTHER_ORGAN_NAME = oTHER_ORGAN_NAME;
	}
	public String getOTHER_ORGAN_PHONE_NUM() {
		return OTHER_ORGAN_PHONE_NUM;
	}
	public void setOTHER_ORGAN_PHONE_NUM(String oTHER_ORGAN_PHONE_NUM) {
		OTHER_ORGAN_PHONE_NUM = oTHER_ORGAN_PHONE_NUM;
	}
	public String getOTHER_ORGAN_COMPANY_NAME() {
		return OTHER_ORGAN_COMPANY_NAME;
	}
	public void setOTHER_ORGAN_COMPANY_NAME(String oTHER_ORGAN_COMPANY_NAME) {
		OTHER_ORGAN_COMPANY_NAME = oTHER_ORGAN_COMPANY_NAME;
	}
	public String getOTHER_ORGAN_CODE() {
		return OTHER_ORGAN_CODE;
	}
	public void setOTHER_ORGAN_CODE(String oTHER_ORGAN_CODE) {
		OTHER_ORGAN_CODE = oTHER_ORGAN_CODE;
	}
	public String getOTHER_ORGAN_ADDRESS() {
		return OTHER_ORGAN_ADDRESS;
	}
	public void setOTHER_ORGAN_ADDRESS(String oTHER_ORGAN_ADDRESS) {
		OTHER_ORGAN_ADDRESS = oTHER_ORGAN_ADDRESS;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getCASE_CODE() {
		return CASE_CODE;
	}
	public void setCASE_CODE(String cASE_CODE) {
		CASE_CODE = cASE_CODE;
	}
	public String getSUBJECT_ID() {
		return SUBJECT_ID;
	}
	public void setSUBJECT_ID(String sUBJECT_ID) {
		SUBJECT_ID = sUBJECT_ID;
	}
	public String getDEPARTMENT_ID() {
		return DEPARTMENT_ID;
	}
	public void setDEPARTMENT_ID(String dEPARTMENT_ID) {
		DEPARTMENT_ID = dEPARTMENT_ID;
	}
	public String getREGISTRANT() {
		return REGISTRANT;
	}
	public void setREGISTRANT(String rEGISTRANT) {
		REGISTRANT = rEGISTRANT;
	}
	public String getENFORCEMENT_DATE() {
		return ENFORCEMENT_DATE;
	}
	public void setENFORCEMENT_DATE(String eNFORCEMENT_DATE) {
		ENFORCEMENT_DATE = eNFORCEMENT_DATE;
	}
	public String getREGISTRANT_DATE() {
		return REGISTRANT_DATE;
	}
	public void setREGISTRANT_DATE(String rEGISTRANT_DATE) {
		REGISTRANT_DATE = rEGISTRANT_DATE;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getPARTY_TYPE() {
		return PARTY_TYPE;
	}
	public void setPARTY_TYPE(String pARTY_TYPE) {
		PARTY_TYPE = pARTY_TYPE;
	}
	public String getCITIZEN_NAME() {
		return CITIZEN_NAME;
	}
	public void setCITIZEN_NAME(String cITIZEN_NAME) {
		CITIZEN_NAME = cITIZEN_NAME;
	}
	public String getCITIZEN_SEX() {
		return CITIZEN_SEX;
	}
	public void setCITIZEN_SEX(String cITIZEN_SEX) {
		CITIZEN_SEX = cITIZEN_SEX;
	}
	public String getCITIZEN_CARD_TYPE() {
		return CITIZEN_CARD_TYPE;
	}
	public void setCITIZEN_CARD_TYPE(String cITIZEN_CARD_TYPE) {
		CITIZEN_CARD_TYPE = cITIZEN_CARD_TYPE;
	}
	public String getCITIZEN_CARD_CODE() {
		return CITIZEN_CARD_CODE;
	}
	public void setCITIZEN_CARD_CODE(String cITIZEN_CARD_CODE) {
		CITIZEN_CARD_CODE = cITIZEN_CARD_CODE;
	}
	public String getCITIZEN_COMPANY() {
		return CITIZEN_COMPANY;
	}
	public void setCITIZEN_COMPANY(String cITIZEN_COMPANY) {
		CITIZEN_COMPANY = cITIZEN_COMPANY;
	}
	public String getCITIZEN_ADDRESS() {
		return CITIZEN_ADDRESS;
	}
	public void setCITIZEN_ADDRESS(String cITIZEN_ADDRESS) {
		CITIZEN_ADDRESS = cITIZEN_ADDRESS;
	}
	public String getCOMPANY_NAME() {
		return COMPANY_NAME;
	}
	public void setCOMPANY_NAME(String cOMPANY_NAME) {
		COMPANY_NAME = cOMPANY_NAME;
	}
	public String getPRINCIPAL() {
		return PRINCIPAL;
	}
	public void setPRINCIPAL(String pRINCIPAL) {
		PRINCIPAL = pRINCIPAL;
	}
	public String getORGANIZATION_CODE() {
		return ORGANIZATION_CODE;
	}
	public void setORGANIZATION_CODE(String oRGANIZATION_CODE) {
		ORGANIZATION_CODE = oRGANIZATION_CODE;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	public String getPUNISHMENT_CODE() {
		return PUNISHMENT_CODE;
	}
	public void setPUNISHMENT_CODE(String pUNISHMENT_CODE) {
		PUNISHMENT_CODE = pUNISHMENT_CODE;
	}
	public String getPUNISHMENT_DATE() {
		return PUNISHMENT_DATE;
	}
	public void setPUNISHMENT_DATE(String pUNISHMENT_DATE) {
		PUNISHMENT_DATE = pUNISHMENT_DATE;
	}
	public String getPD_SENT_DATE() {
		return PD_SENT_DATE;
	}
	public void setPD_SENT_DATE(String pD_SENT_DATE) {
		PD_SENT_DATE = pD_SENT_DATE;
	}
	public String getPP_SENT_DATE() {
		return PP_SENT_DATE;
	}
	public void setPP_SENT_DATE(String pP_SENT_DATE) {
		PP_SENT_DATE = pP_SENT_DATE;
	}
	public String getSENT_WAY() {
		return SENT_WAY;
	}
	public void setSENT_WAY(String sENT_WAY) {
		SENT_WAY = sENT_WAY;
	}
	public String getIS_WARN() {
		return IS_WARN;
	}
	public void setIS_WARN(String iS_WARN) {
		IS_WARN = iS_WARN;
	}
	public String getIS_FINE() {
		return IS_FINE;
	}
	public void setIS_FINE(String iS_FINE) {
		IS_FINE = iS_FINE;
	}
	public String getFINE_SUM() {
		return FINE_SUM;
	}
	public void setFINE_SUM(String fINE_SUM) {
		FINE_SUM = fINE_SUM;
	}
	public String getIS_REVOKE_LICENSE() {
		return IS_REVOKE_LICENSE;
	}
	public void setIS_REVOKE_LICENSE(String iS_REVOKE_LICENSE) {
		IS_REVOKE_LICENSE = iS_REVOKE_LICENSE;
	}
	public String getIS_ORDER_CLOSURE() {
		return IS_ORDER_CLOSURE;
	}
	public void setIS_ORDER_CLOSURE(String iS_ORDER_CLOSURE) {
		IS_ORDER_CLOSURE = iS_ORDER_CLOSURE;
	}
	public String getIS_DTAIN() {
		return IS_DTAIN;
	}
	public void setIS_DTAIN(String iS_DTAIN) {
		IS_DTAIN = iS_DTAIN;
	}
	public String getDTAIN_DAYS() {
		return DTAIN_DAYS;
	}
	public void setDTAIN_DAYS(String dTAIN_DAYS) {
		DTAIN_DAYS = dTAIN_DAYS;
	}
	public String getIS_TD_LICENSE() {
		return IS_TD_LICENSE;
	}
	public void setIS_TD_LICENSE(String iS_TD_LICENSE) {
		IS_TD_LICENSE = iS_TD_LICENSE;
	}
	public String getIS_CONFISCATE() {
		return IS_CONFISCATE;
	}
	public void setIS_CONFISCATE(String iS_CONFISCATE) {
		IS_CONFISCATE = iS_CONFISCATE;
	}
	public String getCONFISCATE_MONEY() {
		return CONFISCATE_MONEY;
	}
	public void setCONFISCATE_MONEY(String cONFISCATE_MONEY) {
		CONFISCATE_MONEY = cONFISCATE_MONEY;
	}
	public String getIS_CONFIS_PROPERTY() {
		return IS_CONFIS_PROPERTY;
	}
	public void setIS_CONFIS_PROPERTY(String iS_CONFIS_PROPERTY) {
		IS_CONFIS_PROPERTY = iS_CONFIS_PROPERTY;
	}
	public String getCONFISCATE_DETAIL() {
		return CONFISCATE_DETAIL;
	}
	public void setCONFISCATE_DETAIL(String cONFISCATE_DETAIL) {
		CONFISCATE_DETAIL = cONFISCATE_DETAIL;
	}
	public String getCONFISCATE_PRO_MON() {
		return CONFISCATE_PRO_MON;
	}
	public void setCONFISCATE_PRO_MON(String cONFISCATE_PRO_MON) {
		CONFISCATE_PRO_MON = cONFISCATE_PRO_MON;
	}
	public String getIS_FORCE() {
		return IS_FORCE;
	}
	public void setIS_FORCE(String iS_FORCE) {
		IS_FORCE = iS_FORCE;
	}
	public String getIS_LIMIT_FREE() {
		return IS_LIMIT_FREE;
	}
	public void setIS_LIMIT_FREE(String iS_LIMIT_FREE) {
		IS_LIMIT_FREE = iS_LIMIT_FREE;
	}
	public String getIS_DISTRESS() {
		return IS_DISTRESS;
	}
	public void setIS_DISTRESS(String iS_DISTRESS) {
		IS_DISTRESS = iS_DISTRESS;
	}
	public String getIS_DTAIN_PROPERTY() {
		return IS_DTAIN_PROPERTY;
	}
	public void setIS_DTAIN_PROPERTY(String iS_DTAIN_PROPERTY) {
		IS_DTAIN_PROPERTY = iS_DTAIN_PROPERTY;
	}
	public String getIS_FRESS() {
		return IS_FRESS;
	}
	public void setIS_FRESS(String iS_FRESS) {
		IS_FRESS = iS_FRESS;
	}
	public String getIS_ORTHER_FORCE() {
		return IS_ORTHER_FORCE;
	}
	public void setIS_ORTHER_FORCE(String iS_ORTHER_FORCE) {
		IS_ORTHER_FORCE = iS_ORTHER_FORCE;
	}
	public String getIS_HEARING() {
		return IS_HEARING;
	}
	public void setIS_HEARING(String iS_HEARING) {
		IS_HEARING = iS_HEARING;
	}
	public String getHEARING_INFORM_DATE() {
		return HEARING_INFORM_DATE;
	}
	public void setHEARING_INFORM_DATE(String hEARING_INFORM_DATE) {
		HEARING_INFORM_DATE = hEARING_INFORM_DATE;
	}
	public String getHEARING_NOTICE_DATE() {
		return HEARING_NOTICE_DATE;
	}
	public void setHEARING_NOTICE_DATE(String hEARING_NOTICE_DATE) {
		HEARING_NOTICE_DATE = hEARING_NOTICE_DATE;
	}
	public String getHEARING_HOLD_DATE() {
		return HEARING_HOLD_DATE;
	}
	public void setHEARING_HOLD_DATE(String hEARING_HOLD_DATE) {
		HEARING_HOLD_DATE = hEARING_HOLD_DATE;
	}
	public String getHEARING_HOST() {
		return HEARING_HOST;
	}
	public void setHEARING_HOST(String hEARING_HOST) {
		HEARING_HOST = hEARING_HOST;
	}
	public String getHEARING_PARTICIPANTS() {
		return HEARING_PARTICIPANTS;
	}
	public void setHEARING_PARTICIPANTS(String hEARING_PARTICIPANTS) {
		HEARING_PARTICIPANTS = hEARING_PARTICIPANTS;
	}
	public String getIS_COLLECTIVE_DISCUSSION() {
		return IS_COLLECTIVE_DISCUSSION;
	}
	public void setIS_COLLECTIVE_DISCUSSION(String iS_COLLECTIVE_DISCUSSION) {
		IS_COLLECTIVE_DISCUSSION = iS_COLLECTIVE_DISCUSSION;
	}
	public String getCOLLECTIVE_DISCUSSION_DATE() {
		return COLLECTIVE_DISCUSSION_DATE;
	}
	public void setCOLLECTIVE_DISCUSSION_DATE(String cOLLECTIVE_DISCUSSION_DATE) {
		COLLECTIVE_DISCUSSION_DATE = cOLLECTIVE_DISCUSSION_DATE;
	}
	public String getCOLLECTIVE_DISCUSS_HOST_NAME() {
		return COLLECTIVE_DISCUSS_HOST_NAME;
	}
	public void setCOLLECTIVE_DISCUSS_HOST_NAME(String cOLLECTIVE_DISCUSS_HOST_NAME) {
		COLLECTIVE_DISCUSS_HOST_NAME = cOLLECTIVE_DISCUSS_HOST_NAME;
	}
	
}
