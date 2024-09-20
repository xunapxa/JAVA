package telBookApp.service;

import java.util.ArrayList;
import java.util.List;

import telBookApp.dao.CrudInterface;
import telBookApp.dao.TelBookDAO;
import telBookApp.dto.TelBookDto;
import telBookApp.entity.TelBook;

public class TelbookService {

	CrudInterface dao = new TelBookDAO();

	public void Input(TelBookDto dto) {
//		System.out.println("데이터 입력 처리 서비스");
		System.out.println(dto);
		int result = dao.insert(TelBookDto.fromDto(dto));
		if(result > 0) {
			System.out.println("저장되었습니다.");
		} else {
			System.out.println("저장에 실패했습니다.");			
		}
	}

	public void Update(TelBookDto dto) {
		System.out.println("데이터 수정 처리 서비스");
		int result = dao.update(TelBookDto.fromDtos(dto));
		if(result > 0) {
			System.out.println("수정되었습니다.");
		} else {
			System.out.println("수정에 실패했습니다.");			
		}
	}

	public void Delete(Long deleteId) {
//		System.out.println("데이터 삭제 처리 서비스");
		if(dao.delete(deleteId) > 0) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
	}

	public List<TelBookDto> ShowAll() {
		List<TelBookDto> bookDtos = new ArrayList<TelBookDto>();
		
//		System.out.println("전체데이터 출력 처리 서비스");
		List<TelBook> entityLists = dao.getListAll();
		
		// 가져온 TelBook 리스트를 TelBookDto 리스트로 바꿔주기
		for(TelBook book : entityLists) {
			bookDtos.add(TelBookDto.fromEntity(book));
		}
		return bookDtos;
		
		// 출력 테스트
//		System.out.println(bookDtos);
	}

	public TelBookDto SearchId(Long id) {
//		System.out.println("아이디 검색 처리 서비스");
		TelBook book = dao.getOne(id);
		
		
		if(book == null) {
			System.out.println("자료 없음");
			return null;
		} else {
			return TelBookDto.fromEntity(dao.getOne(id));
		}
//		return ;
	}

	public List<TelBookDto> searchKeyword(int num, String keyword) {
		List<TelBook> telBooks = dao.serchKeyword(num, keyword);
		return telBooks.stream()
				.map(x -> TelBookDto.fromEntity(x))
				.toList();
	}
}
