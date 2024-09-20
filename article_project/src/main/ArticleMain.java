package main;

import java.util.Scanner;

import view.ArticleView;

public class ArticleMain {
	public static Scanner sc = new Scanner(System.in);
	public static ArticleView articleView = new ArticleView();
	
	public static void main(String[] args) {
		while(true) {
			System.out.println("게시글 리스트");
			System.out.println("0. 전체보기 1. 새글 2. 자세히보기 3. 삭제 4. 수정 5. 종료");
			int num = sc.nextInt();
			
			switch(num) {
			case 0:
				// 전체글 보기
				articleView.showAll();
				break;
			case 1:
				// 새글 작성하기
				articleView.showNewArticle();
				break;
			case 2:
				// 자세히 보기
				articleView.showDetail();
				break;
			case 3:
				// 게시글 삭제
				articleView.showDelete();
				break;
			case 4:
				// 글 수정 (제목,내용만)
				articleView.showUpdate();
				break;
			case 5:
				// 종료하기
				return;
			default:
				System.out.println("입력 오류");
			}
		}
	}
}
