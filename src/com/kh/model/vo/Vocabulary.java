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
	private String[] vocaKor = {"���", "~�� �����ϴ�", "~�κ��� ������ �޴�", "�����ϴ�", "~�� �����ϴ�",
			"~�� �����ϴ�", "�ǽ�, �����ϴ�", "�����, �������", "������ , ����", "Ȯ����",
			"~�� �����ϴ�", "�ݳ⸶����", "����, ������", "Ȯ�ε�", "������ ����",
			"������", "�м�, �����ϴ�", "���ӷ� �ִ�, �ǹ�����", "��꼭, û����, ����", "��Ȯ��",
			"����, ����", "����ų �� ����", "�����ϴ�, �߱�, ����", "�ذ�Ǵ�", "�Ÿ���",
			"����, �����", "���ེ����", "�ǻ�����", "����", "����",
			"���ʿ���", "���� ��������", "��������", "�����", "�����ϴ�",
			"����", "�����ϴ�", "��ȣ��", "�ַ�, �뷮����", "��������, ��������",
			"����, ������� ȭ���", "����, ����", "¥������(�����ϰ�)�ϴ�", "������, ������ ����", "������, �Ʒ��� �ִ�",
			"����������, �������", "�����ϴ�", "�븮��", "�Ͼ��, ��Ÿ����", "����ϴ�",
			"���, ���", "����, ����, ����", "������ �Ǵ�", "�����ϴ�, �缺�ϴ�", "���",
			"��, ����(��)", "����ϴ�", "����, ����, ������", "¥������(�����ϰ�)�ϴ�", "������, ������ ����",
			"������, �Ʒ��� �ִ�", "�����ϴ�", "�����ϴ�", "�����ϴ�, �����ϴ�", "��������;��������",
			"�����ϴ�, ��������", "�߰��ϰ� �ϴ�", "���ϰ��ϴ�, ��������", "�����ϴ�", "�ø���, ���Ľ�Ű��",
			"�����Ű��;�����ϴ�", "�����", "�����, �����", "��û(ź��, �ֿ�)�ϴ�", "�Ӹ��ϴ�",
			"������ϴ�", "�����ϴ�, �����ϴ�", "����(����)�ϴ�", "��ǰ�ϴ�", "������",
			"�׸��� ���� �޸� ȭ��", "���, �ּ�", "�뿹 ����", "�޾�;����ȸ��", "�ð�����",
			"�ð��� �����ϴ�", "��Ȥ, ��������", "���� ��, �η�, ����(��)", "�����, �ε�����, Ÿ����", "�ҽ�, ��Ȥ, �ǽ��ϴ�",
			"����, ����è, �ǽ�, ����", "����ϴ�", "��ġ��, ~�� �����ϴ�", "�ڸ�, �ں�, �Ÿ�", "�ڶ��ϰ� �ִ�",
			"�����ϴ�, �����ϴ�", "�����ϴ�, �𸣴�ü�ϴ�", "����, ���, �����ϴ�", "�¸�, ��Ȧ", "�����ϴ�, ~�����̴�",
			"�Ӹ�, ����", "���, �Ӹ�", "�����ϴ�", "Ī���ϴ�", "ã�ƴٴϴ�"};
	
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
