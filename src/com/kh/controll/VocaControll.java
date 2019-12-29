package com.kh.controll;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import com.kh.model.vo.Vocabulary;

public class VocaControll {
	private Vocabulary voca = new Vocabulary();
	Scanner s = new Scanner(System.in);
	
	public void mainMenu() {
		System.out.println("---------------------------");
		System.out.println("                토익 필수단어 100");
		System.out.println("---------------------------");
		
		while(true) {
			System.out.println("1. 전체 단어 출력");
			System.out.println("2. 한 단어씩 공부하기");
			System.out.println("3. 내 단어장 공부하기");
			System.out.println("4. 종료");
			System.out.print("선택 : ");
			int menu = s.nextInt();
			s.nextLine();
			System.out.println();
			
			switch(menu) {
			case 1: printAll(); break;
			case 2: studyVoca(); break;
			case 3: myVocabulary(); break;
			case 4: System.out.println("종료하겠습니다."); break;
			default: break;
			}
			
			System.out.println();
		}
		
		
	}
	
	public void printAll() {
		int index = 0;
		Iterator<Map.Entry<String, String>> it = voca.getVocaList().entrySet().iterator();
		
		while(it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			System.out.printf("%d번 : %s, %s\n", (index++ + 1), entry.getKey(), entry.getValue());
		}
		
	}
	
	public void studyVoca() {
		Iterator<Map.Entry<String, String>> it = voca.getVocaList().entrySet().iterator();
		Iterator<Map.Entry<String, String>> it2 = voca.getVocaList().entrySet().iterator();
		
		int question = (int)(Math.random() * 30);
		for(int i = 0; i < question; i++) {
			it.next();
		}
		String answer;
		int[] list = new int[3];
		String[] stringList = new String[3];
			
		// 탈출 조건 설명
		System.out.println("단어 공부를 시작하겠습니다. 1~4까지 해당 영단어에 알맞은 정답을 입력하시면 됩니다.");
		System.out.println("그리고 0을 입력하시면 단어장 공부가 종료됩니다.\n");
		s.nextLine();
		
		// 객관식 UI
		while(it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			String matter = entry.getKey();
			System.out.println(entry.getKey());
			answer = entry.getValue();
				
			// 객관식 리스트들 랜덤으로 인덱스
			for(int i = 0; i < 3; i++) {
				int random;
				while(true) {
					random = (int)(Math.random() * 100);
						
					list[i] = random;
					break;
				}
					
			}
				
			// 객관식 보기들에 값 넣기
			for(int i = 0; i < list.length; i++) {
				it2 = voca.getVocaList().entrySet().iterator();
				for(int j = 0; j < list[i]; j++) {
					if(j == list[i] - 1) {
						stringList[i] = it2.next().getValue();
						break;
					}else {
						it2.next();
					}
				}
			}
				
			// 객관식 보기
			String[] choice = new String[4];	
			int[] prevValue = new int[100];
			int prevIndex = 0;
			int count = 0;
			while(count < 4) {
				boolean isOverlap = false;
				int random = (int)(Math.random() * 4);
				
				// 객관식에 넣을 숫자가 중복되었는지
				for(int i = 0; i < prevIndex; i++) {
					if(prevValue[i] == random) {
						isOverlap = true;
						break;
					}
				}
				if(isOverlap) {
					continue;
				}else {
					prevValue[prevIndex++] = random;
				}
				
				switch(random) {
				case 0:
					choice[count++] = answer; break;
				case 1:
					choice[count++] = stringList[0]; break;
				case 2:
					choice[count++] = stringList[1]; break;
				case 3:
					choice[count++] = stringList[2]; break;
				}
			}
			
			// 객관식 보기 출력
			for(int i = 0; i < choice.length; i++) {
				System.out.printf("%d : %s        ", (i + 1), choice[i]);
			}
			System.out.println();
			
			// 객관식 정답 맞추기
			int select = 0;
			while(true) {
				System.out.print("올바른 것을 택하시오 : ");
				select = s.nextInt();
				s.nextLine();
			
				if(select > 4) {
					System.out.println("올바르지 않은 숫자를 입력하셨습니다. 1~4까지 입력해주세요.");
				}else if(select == 0) {
					System.out.println("단어 공부를 종료하겠습니다.");
					return;
				}else {
					break;
				}
			}
			
			if(choice[select - 1].equals(answer)) {
				System.out.println("정답입니다. 다음 문제로 넘어가겠습니다.\n");
			}else {
				System.out.printf("틀렸습니다. 해당 단어의 뜻은 \"%s\"이며, 나만의 단어장에 저장하려면 'Y', 넘어가시려면 'N'을 입력해주세요. : ", answer);
				String menu = s.nextLine();
				if(menu.equalsIgnoreCase("Y")) {
					System.out.println("단어장에 저장되었습니다.");
					voca.addMyVoca(matter, answer);
					System.out.println();
				}else {
					System.out.println();
				}
			}
			
		}
		System.out.println("단어 100개를 다 공부하셨습니다.");
		System.out.println();
	}
	
	public void myVocabulary() {
		while(true) {
			HashMap<String, String> myVoca = voca.getMyVoca();
			System.out.println("1. 내 단어장 전체 출력");
			System.out.println("2. 내 단어장 공부");
			System.out.println("3. 종료");
			System.out.print("선택 : ");
			int menu = s.nextInt();
			s.nextLine();
			
			if(menu == 1) {
				printVocabulary(myVoca);
			}else if(menu == 2) {
				studyMyVoca(myVoca);
			}else if(menu == 3) {	
				return;
			}else {
				System.out.println("1, 2, 3 중 하나를 선택해 주십시오.");
			}
				
		}
			
		
	}
	
	public void printVocabulary(HashMap<String, String> myVoca) {
		Iterator<Map.Entry<String, String>> iter =  myVoca.entrySet().iterator();
		
		// 아직 단어장에 단어가 없을 시
		if(!(iter.hasNext())) {
			System.out.println("저장된 단어가 없습니다.");
			return;
		}
		
		while(iter.hasNext()) {
			Map.Entry<String, String> entry = iter.next();
			System.out.printf("%s : %s\n", entry.getKey(), entry.getValue());
		}
		System.out.println();
	}
	
	public void studyMyVoca(HashMap<String, String> myVoca) {
		
		Iterator<Map.Entry<String, String>> it = voca.getMyVoca().entrySet().iterator();
		Iterator<Map.Entry<String, String>> it2 = voca.getMyVoca().entrySet().iterator();
		
		// 아직 단어장에 단어가 없을 시
		if(!(it.hasNext())) {
			System.out.println("저장된 단어가 없습니다.");
			return;
		}
		
		int question = (int)(Math.random() * 30);
		for(int i = 0; i < question; i++) {
			it.next();
		}
		String answer;
		int[] list = new int[3];
		String[] stringList = new String[3];
			
		// 탈출 조건 설명
		System.out.println("내 단어장에 있는 단어 공부를 시작하겠습니다. 1~4까지 해당 영단어에 알맞은 정답을 입력하시면 됩니다.");
		System.out.println("그리고 0을 입력하시면 단어장 공부가 종료됩니다.\n");
		s.nextLine();
		
		// 객관식 UI
		while(it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			String matter = entry.getKey();
			System.out.println(entry.getKey());
			answer = entry.getValue();
				
			// 객관식 리스트들 랜덤으로 인덱스
			for(int i = 0; i < 3; i++) {
				int random;
				while(true) {
					random = (int)(Math.random() * 100);
						
					list[i] = random;
					break;
				}
					
			}
				
			// 객관식 보기들에 값 넣기
			for(int i = 0; i < list.length; i++) {
				it2 = voca.getVocaList().entrySet().iterator();
				for(int j = 0; j < list[i]; j++) {
					if(j == list[i] - 1) {
						stringList[i] = it2.next().getValue();
						break;
					}else {
						it2.next();
					}
				}
			}
				
			// 객관식 보기
			String[] choice = new String[4];	
			int[] prevValue = new int[100];
			int prevIndex = 0;
			int count = 0;
			while(count < 4) {
				boolean isOverlap = false;
				int random = (int)(Math.random() * 4);
				
				// 객관식에 넣을 숫자가 중복되었는지
				for(int i = 0; i < prevIndex; i++) {
					if(prevValue[i] == random) {
						isOverlap = true;
						break;
					}
				}
				if(isOverlap) {
					continue;
				}else {
					prevValue[prevIndex++] = random;
				}
				
				switch(random) {
				case 0:
					choice[count++] = answer; break;
				case 1:
					choice[count++] = stringList[0]; break;
				case 2:
					choice[count++] = stringList[1]; break;
				case 3:
					choice[count++] = stringList[2]; break;
				}
			}
			
			// 객관식 보기 출력
			for(int i = 0; i < choice.length; i++) {
				System.out.printf("%d : %s        ", (i + 1), choice[i]);
			}
			System.out.println();
			
			// 객관식 정답 맞추기
			int select = 0;
			while(true) {
				System.out.print("올바른 것을 택하시오 : ");
				select = s.nextInt();
				s.nextLine();
			
				if(select > 4) {
					System.out.println("올바르지 않은 숫자를 입력하셨습니다. 1~4까지 입력해주세요.");
				}else if(select == 0) {
					System.out.println("단어 공부를 종료하겠습니다.");
					return;
				}else {
					break;
				}
			}
			
			if(choice[select - 1].equals(answer)) {
				System.out.println("정답입니다. 다음 문제로 넘어가겠습니다.\n");
			}else {
				System.out.printf("틀렸습니다. 해당 단어의 뜻은 \"%s\"이며, 나만의 단어장에 저장하려면 'Y', 넘어가시려면 'N'을 입력해주세요. : ", answer);
				String menu = s.nextLine();
				if(menu.equalsIgnoreCase("Y")) {
					System.out.println("단어장에 저장되었습니다.");
					voca.addMyVoca(matter, answer);
					System.out.println();
				}else {
					System.out.println();
				}
			}
			
		}
		System.out.println("내 단어장에 있는 단어를 모두 공부했습니다.");
	}
}
