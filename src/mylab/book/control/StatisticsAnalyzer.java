package mylab.book.control;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class StatisticsAnalyzer {


    // 1. 타입별 평균 가격 계산
    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        // 타입별 총 가격
        Map<String, Integer> totalPrices = new HashMap<>();
        // 타입별 개수
        Map<String, Integer> counts = new HashMap<>();


        // 모든 출판물 확인
        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            // 총 가격 누적
            totalPrices.put(type,totalPrices.getOrDefault(type, 0)+ pub.getPrice());
            // 개수 증가
            counts.put(type,counts.getOrDefault(type, 0) + 1);
        }


        // 평균 계산
        Map<String, Double> averages = new HashMap<>();

        for (String type : totalPrices.keySet()) {
            double average =(double) totalPrices.get(type)/ counts.get(type);
            averages.put(type, average);
        }
        return averages;
    }


    // 2. 출판물 유형별 분포 계산
    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> counts = new HashMap<>();


        // 타입별 개수 계산
        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            counts.put(type,counts.getOrDefault(type, 0) + 1
            );
        }


        // 전체 개수
        int total = publications.length;
        Map<String, Double> distribution = new HashMap<>();

        // 각 타입의 비율 계산
        for (String type : counts.keySet()) {
        	double percentage =(double) counts.get(type)/ total * 100;
            distribution.put(type, percentage);
        }
        return distribution;
    }


    // 3. 특정 연도 출판물 비율 계산
    public double calculatePublicationRatioByYear(Publication[] publications,String year) {
        int count = 0;

        for (Publication pub : publications) {
            String publishDate = pub.getPublishDate();
            String publishYear = publishDate.substring(0, 4);
            if (publishYear.equals(year)) {
                count++;
            }
        }

        if (publications.length == 0) {
            return 0;
        }
        return (double) count / publications.length * 100;
    }


    // 4. 출판물 타입 확인
    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) {
            return "소설";
        } else if (pub instanceof Magazine) {
            return "잡지";
        } else if (pub instanceof ReferenceBook) {
            return "참고서";
        } else {
            return "기타";
        }
    }


    // 5. 통계 출력
    public void printStatistics(Publication[] publications) {
        // 숫자 출력 형식
        DecimalFormat df = new DecimalFormat("#,###.##");
        // 타입별 평균 가격
        Map<String, Double> averagePrices =calculateAveragePriceByType(publications);


        System.out.println("------ 타입별 평균 가격 ------");
        for (String type : averagePrices.keySet()) {
            System.out.println(type + ": "+ df.format(averagePrices.get(type))+ "원");
        }


        // 출판물 유형 분포
        Map<String, Double> distribution =calculatePublicationDistribution(publications);


        System.out.println();
        System.out.println("------ 출판물 유형 분포 ------");

        for (String type : distribution.keySet()) {
            System.out.println(type + ": " + df.format(distribution.get(type))+ "%");
        }


        // 2007년도 출판물 비율
        double ratio = calculatePublicationRatioByYear(publications,"2007");

        System.out.println();
        System.out.println("------ 특정 연도 출판 비율 ------");
        System.out.println("2007년 출판물 비율: "+ df.format(ratio)+ "%");
    }
}