package com.kh.model.vo;

import java.util.Arrays;
import java.util.HashMap;

public class Vocabulary {
	private HashMap<String, String> vocaList;
	private HashMap<String, String> myVoca;
	
	private String[] vocaEng = {"account", "account for", "benefit from", "condense", "condense into", 
			"better", "conduct", "accrue", "conductor", "confirmation",
			"be aware of", "biannual", "accumulation", "confirmed", "beneficial",
			"beneficiary", "confiscate", "binding", "bill", "accurately",
			"achievement",  "irretrievable", "issue", "be laid off", "landfill",
			"landslide", "itinerary", "agenda", "mutually", "natural disaster",
			"needlessly", "jet lag", "keynote speech", "laboratory", "lack",
			"municipal", "multiply", "mutual", "largely", "lastingly",
			"lavatory", "support", "irritate", "generous", "tolerant",
			"liberal", "reject", "substitute", "occur", "despise",
			"contempt", "gain", "avail", "educate", "resemble",
			"grasp", "reconsider", "support", "irritate", "generous",
			"tolerant", "prove", "illustrate", "exemplify", "conservative",
			"progressive", "fortify", "strengthen", "reinforce", "multiply",
			"reproduce", "elicit", "extract", "implore", "appoint",
			"disgust", "preach", "worship", "yawn", "hiccup",
			"quarrel", "pillar", "servitude", "recreation", "punctuality",
			"punctual", "fascination", "attraction", "vicious", "distrust",
			"suspicion", "endeavor", "devote", "pride", "proud",
			"discontinue", "ignore", "disregard", "neglect", "depend",
			"nomination", "appointment", "predict", "praise", "forage"};
	private String[] vocaKor = {"계산", "~를 설명하다", "~로부터 혜택을 받다", "압축하다", "~로 압축하다",
			"~를 개선하다", "실시, 시행하다", "생기다, 얻어지다", "지휘자 , 차장", "확정서",
			"~를 조심하다", "반년마다의", "축적, 축적물", "확인된", "혜택이 많은",
			"수혜자", "압수, 몰수하다", "구속력 있는, 의무적인", "계산서, 청구서, 법안", "정확히",
			"업적, 성과", "돌이킬 수 없는", "발행하다, 발급, 문제", "해고되다", "매립지",
			"사태, 산사태", "여행스케줄", "의사일정", "서로", "재해",
			"불필요한", "시차 부적응중", "기조연설", "실험실", "부족하다",
			"시의", "급증하다", "상호의", "주로, 대량으로", "영속적인, 영구적인",
			"기차, 비행기의 화장실", "지지, 지주", "짜증나게(초조하게)하다", "관대한, 마음이 넓은", "관대한, 아량이 있는",
			"자유주의자, 자유당원", "거절하다", "대리의", "일어나다, 나타나다", "경멸하다",
			"경멸, 멸시", "이익, 증가, 진보", "도움이 되다", "교육하다, 양성하다", "닮다",
			"쥠, 지배(력)", "재고하다", "지지, 지주, 지지물", "짜증나게(초조하게)하다", "관대한, 마음이 넓은",
			"관대한, 아량이 있는", "입증하다", "설명하다", "예시하다, 예증하다", "보수적인;전통적인",
			"전진하는, 누진적인", "견고하게 하다", "강하게하다, 강해지다", "보강하다", "늘리다, 번식시키다",
			"재생시키다;재현하다", "끌어내다", "끌어내다, 빼어내다", "간청(탄원, 애원)하다", "임명하다",
			"역겹게하다", "설교하다, 전도하다", "숭배(존경)하다", "하품하다", "딸꾹질",
			"네모진 촉이 달린 화살", "기둥, 주석", "노예 상태", "휴양;원기회복", "시간엄수",
			"시간을 엄수하는", "매혹, 눈독들임", "끄는 힘, 인력, 흡인(력)", "사악한, 부도덕한, 타락한", "불신, 의혹, 의심하다",
			"느낌, 낌새챔, 의심, 협의", "노력하다", "바치다, ~에 몰두하다", "자만, 자부, 거만", "자랑하고 있는",
			"중지하다, 정지하다", "무시하다, 모르는체하다", "무시, 경시, 무시하다", "태만, 소홀", "의지하다, ~나름이다",
			"임명, 지명", "약속, 임명", "예측하다", "칭찬하다", "찾아다니다"};
	
	public Vocabulary(){
		vocaList = new HashMap<>();
		for(int i = 0; i < vocaEng.length; i++) {
			vocaList.put(vocaEng[i], vocaKor[i]);
		}
		
		myVoca = new HashMap<String, String>();
	}
	
	public HashMap<String, String> getVocaList() {
		return vocaList;
	}
	public void setVocaList(HashMap<String, String> vocaList) {
		this.vocaList = vocaList;
	}
	public HashMap<String, String> getMyVoca() {
		return myVoca;
	}
	public void setMyVoca(HashMap<String, String> myVoca) {
		this.myVoca = myVoca;
	}
	public void addMyVoca(String eng, String kor) {
		myVoca.put(eng, kor);
	}
	public String[] getVocaEng() {
		return vocaEng;
	}
	public void setVocaEng(String[] vocaEng) {
		this.vocaEng = vocaEng;
	}
	public String[] getVocaKor() {
		return vocaKor;
	}
	public void setVocaKor(String[] vocaKor) {
		this.vocaKor = vocaKor;
	}
	

}
