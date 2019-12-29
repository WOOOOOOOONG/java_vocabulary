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
		System.out.println("                ���� �ʼ��ܾ� 100");
		System.out.println("---------------------------");
		
		while(true) {
			System.out.println("1. ��ü �ܾ� ���");
			System.out.println("2. �� �ܾ �����ϱ�");
			System.out.println("3. �� �ܾ��� �����ϱ�");
			System.out.println("4. ����");
			System.out.print("���� : ");
			int menu = s.nextInt();
			s.nextLine();
			System.out.println();
			
			switch(menu) {
			case 1: printAll(); break;
			case 2: studyVoca(); break;
			case 3: myVocabulary(); break;
			case 4: System.out.println("�����ϰڽ��ϴ�."); break;
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
			System.out.printf("%d�� : %s, %s\n", (index++ + 1), entry.getKey(), entry.getValue());
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
			
		// Ż�� ���� ����
		System.out.println("�ܾ� ���θ� �����ϰڽ��ϴ�. 1~4���� �ش� ���ܾ �˸��� ������ �Է��Ͻø� �˴ϴ�.");
		System.out.println("�׸��� 0�� �Է��Ͻø� �ܾ��� ���ΰ� ����˴ϴ�.\n");
		s.nextLine();
		
		// ������ UI
		while(it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			String matter = entry.getKey();
			System.out.println(entry.getKey());
			answer = entry.getValue();
				
			// ������ ����Ʈ�� �������� �ε���
			for(int i = 0; i < 3; i++) {
				int random;
				while(true) {
					random = (int)(Math.random() * 100);
						
					list[i] = random;
					break;
				}
					
			}
				
			// ������ ����鿡 �� �ֱ�
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
				
			// ������ ����
			String[] choice = new String[4];	
			int[] prevValue = new int[100];
			int prevIndex = 0;
			int count = 0;
			while(count < 4) {
				boolean isOverlap = false;
				int random = (int)(Math.random() * 4);
				
				// �����Ŀ� ���� ���ڰ� �ߺ��Ǿ�����
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
			
			// ������ ���� ���
			for(int i = 0; i < choice.length; i++) {
				System.out.printf("%d : %s        ", (i + 1), choice[i]);
			}
			System.out.println();
			
			// ������ ���� ���߱�
			int select = 0;
			while(true) {
				System.out.print("�ùٸ� ���� ���Ͻÿ� : ");
				select = s.nextInt();
				s.nextLine();
			
				if(select > 4) {
					System.out.println("�ùٸ��� ���� ���ڸ� �Է��ϼ̽��ϴ�. 1~4���� �Է����ּ���.");
				}else if(select == 0) {
					System.out.println("�ܾ� ���θ� �����ϰڽ��ϴ�.");
					return;
				}else {
					break;
				}
			}
			
			if(choice[select - 1].equals(answer)) {
				System.out.println("�����Դϴ�. ���� ������ �Ѿ�ڽ��ϴ�.\n");
			}else {
				System.out.printf("Ʋ�Ƚ��ϴ�. �ش� �ܾ��� ���� \"%s\"�̸�, ������ �ܾ��忡 �����Ϸ��� 'Y', �Ѿ�÷��� 'N'�� �Է����ּ���. : ", answer);
				String menu = s.nextLine();
				if(menu.equalsIgnoreCase("Y")) {
					System.out.println("�ܾ��忡 ����Ǿ����ϴ�.");
					voca.addMyVoca(matter, answer);
					System.out.println();
				}else {
					System.out.println();
				}
			}
			
		}
		System.out.println("�ܾ� 100���� �� �����ϼ̽��ϴ�.");
		System.out.println();
	}
	
	public void myVocabulary() {
		while(true) {
			HashMap<String, String> myVoca = voca.getMyVoca();
			System.out.println("1. �� �ܾ��� ��ü ���");
			System.out.println("2. �� �ܾ��� ����");
			System.out.println("3. ����");
			System.out.print("���� : ");
			int menu = s.nextInt();
			s.nextLine();
			
			if(menu == 1) {
				printVocabulary(myVoca);
			}else if(menu == 2) {
				studyMyVoca(myVoca);
			}else if(menu == 3) {	
				return;
			}else {
				System.out.println("1, 2, 3 �� �ϳ��� ������ �ֽʽÿ�.");
			}
				
		}
			
		
	}
	
	public void printVocabulary(HashMap<String, String> myVoca) {
		Iterator<Map.Entry<String, String>> iter =  myVoca.entrySet().iterator();
		
		// ���� �ܾ��忡 �ܾ ���� ��
		if(!(iter.hasNext())) {
			System.out.println("����� �ܾ �����ϴ�.");
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
		
		// ���� �ܾ��忡 �ܾ ���� ��
		if(!(it.hasNext())) {
			System.out.println("����� �ܾ �����ϴ�.");
			return;
		}
		
		int question = (int)(Math.random() * 30);
		for(int i = 0; i < question; i++) {
			it.next();
		}
		String answer;
		int[] list = new int[3];
		String[] stringList = new String[3];
			
		// Ż�� ���� ����
		System.out.println("�� �ܾ��忡 �ִ� �ܾ� ���θ� �����ϰڽ��ϴ�. 1~4���� �ش� ���ܾ �˸��� ������ �Է��Ͻø� �˴ϴ�.");
		System.out.println("�׸��� 0�� �Է��Ͻø� �ܾ��� ���ΰ� ����˴ϴ�.\n");
		s.nextLine();
		
		// ������ UI
		while(it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			String matter = entry.getKey();
			System.out.println(entry.getKey());
			answer = entry.getValue();
				
			// ������ ����Ʈ�� �������� �ε���
			for(int i = 0; i < 3; i++) {
				int random;
				while(true) {
					random = (int)(Math.random() * 100);
						
					list[i] = random;
					break;
				}
					
			}
				
			// ������ ����鿡 �� �ֱ�
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
				
			// ������ ����
			String[] choice = new String[4];	
			int[] prevValue = new int[100];
			int prevIndex = 0;
			int count = 0;
			while(count < 4) {
				boolean isOverlap = false;
				int random = (int)(Math.random() * 4);
				
				// �����Ŀ� ���� ���ڰ� �ߺ��Ǿ�����
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
			
			// ������ ���� ���
			for(int i = 0; i < choice.length; i++) {
				System.out.printf("%d : %s        ", (i + 1), choice[i]);
			}
			System.out.println();
			
			// ������ ���� ���߱�
			int select = 0;
			while(true) {
				System.out.print("�ùٸ� ���� ���Ͻÿ� : ");
				select = s.nextInt();
				s.nextLine();
			
				if(select > 4) {
					System.out.println("�ùٸ��� ���� ���ڸ� �Է��ϼ̽��ϴ�. 1~4���� �Է����ּ���.");
				}else if(select == 0) {
					System.out.println("�ܾ� ���θ� �����ϰڽ��ϴ�.");
					return;
				}else {
					break;
				}
			}
			
			if(choice[select - 1].equals(answer)) {
				System.out.println("�����Դϴ�. ���� ������ �Ѿ�ڽ��ϴ�.\n");
			}else {
				System.out.printf("Ʋ�Ƚ��ϴ�. �ش� �ܾ��� ���� \"%s\"�̸�, ������ �ܾ��忡 �����Ϸ��� 'Y', �Ѿ�÷��� 'N'�� �Է����ּ���. : ", answer);
				String menu = s.nextLine();
				if(menu.equalsIgnoreCase("Y")) {
					System.out.println("�ܾ��忡 ����Ǿ����ϴ�.");
					voca.addMyVoca(matter, answer);
					System.out.println();
				}else {
					System.out.println();
				}
			}
			
		}
		System.out.println("�� �ܾ��忡 �ִ� �ܾ ��� �����߽��ϴ�.");
	}
}
