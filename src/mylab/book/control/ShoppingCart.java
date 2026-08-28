package mylab.book.control;

import java.util.ArrayList;
import java.util.List;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class ShoppingCart {

    // 장바구니에 담긴 출판물 목록
    private List<Publication> items;


    // 생성자
    public ShoppingCart() {
        items = new ArrayList<>();
    }


    // 출판물 추가
    public void addItem(Publication item) {

        items.add(item);

        System.out.println(
                item.getTitle() + "이(가) 장바구니에 추가되었습니다."
        );
    }


    // 출판물 제거
    public boolean removeItem(String title) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getTitle().equals(title)) {
                Publication removed = items.remove(i);
                System.out.println(removed.getTitle() + "이(가) 장바구니에서 제거되었습니다.");
                return true;
            }
        }
        System.out.println("해당 제목의 출판물을 찾을 수 없습니다.");
        return false;
    }


    // 장바구니 내용 출력
    public void displayCart() {
        System.out.println();
        System.out.println("====== 장바구니 ======");
        if (items.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
            return;
        }
        for (int i = 0; i < items.size(); i++) {

            System.out.println((i + 1) + ". " + items.get(i));
        }

        System.out.println("----------------------");
        System.out.println("총 가격: " + calculateTotalPrice() + "원");
        System.out.println("할인 적용 가격: " + calculateDiscountedPrice() + "원");
    }


    // 장바구니의 원래 가격 합계
    public int calculateTotalPrice() {
        int total = 0;
        for (Publication item : items) {
            total += item.getPrice();
        }
        return total;
    }


    // 할인 적용 가격 계산
    public int calculateDiscountedPrice() {
        int total = 0;
        for (Publication item : items) {
            if (item instanceof Magazine) {
                // 10% 할인
                total += (int) (item.getPrice() * 0.9);
            } else if (item instanceof Novel) {
                // 15% 할인
                total += (int) (item.getPrice() * 0.85);
            } else if (item instanceof ReferenceBook) {
                // 20% 할인
                total += (int) (item.getPrice() * 0.8);
            } else {
                // 기타 출판물은 할인 없음
                total += item.getPrice();
            }
        }
        return total;
    }


    // 장바구니 통계
    public void printStatistics() {
        int magazineCount = 0;
        int novelCount = 0;
        int referenceBookCount = 0;

        for (Publication item : items) {
            if (item instanceof Magazine) {
                magazineCount++;
            } else if (item instanceof Novel) {
                novelCount++;
            } else if (item instanceof ReferenceBook) {
                referenceBookCount++;
            }
        }

        System.out.println();
        System.out.println("====== 장바구니 통계 ======");
        System.out.println("잡지: " + magazineCount + "권");
        System.out.println("소설: " + novelCount + "권");
        System.out.println("참고서: " + referenceBookCount + "권");
        System.out.println("총 출판물: " + items.size() + "권");
    }


    // 테스트용 main
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        // 출판물 생성
        Publication magazine = new Magazine("마이크로소프트","2007-10-01",328,9900,"매월");
        Publication magazine2 = new Magazine("경영과컴퓨터","2007-10-03",316,9000,"매월");
        Publication novel = new Novel("빠삐용","2007-07-01",396,9800,"베르나르베르베르","현대소설");
        Publication referenceBook = new ReferenceBook("실용주의프로그래머","2007-01-14",496,25000,"소프트웨어공학");

        // 장바구니에 추가
        cart.addItem(magazine);
        cart.addItem(magazine2);
        cart.addItem(novel);
        cart.addItem(referenceBook);

        // 장바구니 출력
        cart.displayCart();

        // 통계 출력
        cart.printStatistics();

        // 빠삐용 제거
        System.out.println();
        System.out.println("====== 빠삐용 제거 ======");
        cart.removeItem("빠삐용");

        // 변경된 장바구니 출력
        cart.displayCart();

        // 변경된 통계
        cart.printStatistics();
    }
}