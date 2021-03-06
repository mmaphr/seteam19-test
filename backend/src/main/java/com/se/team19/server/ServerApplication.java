package com.se.team19.server;

import com.se.team19.server.Entity.*;
import com.se.team19.server.Repository.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;
import java.util.stream.Stream;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
	CharacterEncodingFilter characterEncodingFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return filter;
	}

	@Bean
	ApplicationRunner init(GenderRepository genderRepository, PositionRepository positionRepository, ProvinceRepository provinceRepository, StaffRepository staffRepository) {
		return args -> {
			Stream.of("ชาย", "หญิง").forEach(GenderName -> {
				genderRepository.save(new Gender(GenderName));
			});
			genderRepository.findAll().forEach(System.out::println);

			Stream.of("ฝ่ายบุคคล", "ช่าง","แพทย์","พยาบาล","พนักงานต้อนรับ").forEach(PositionName -> {
				positionRepository.save(new Position(PositionName));
			});
			positionRepository.findAll().forEach(System.out::println);

			Stream.of("กระบี่","กรุงเทพมหานคร","กาญจนบุรี","กาฬสินธุ์","กำแพงเพชร","ขอนแก่น","จันทบุรี","ฉะเชิงเทรา" ,"ชลบุรี","ชัยนาท","ชัยภูมิ","ชุมพร","เชียงราย","เชียงใหม่","ตรัง","ตราด","ตาก","นครนายก","นครปฐม","นครพนม","นครราชสีมา" ,"นครศรีธรรมราช","นครสวรรค์","นนทบุรี","นราธิวาส","น่าน","บุรีรัมย์","บึงกาฬ","ปทุมธานี","ประจวบคีรีขันธ์","ปราจีนบุรี","ปัตตานี" ,"พะเยา","พังงา","พัทลุง","พิจิตร","พิษณุโลก","เพชรบุรี","เพชรบูรณ์","แพร่","ภูเก็ต","มหาสารคาม","มุกดาหาร","แม่ฮ่องสอน" ,"ยโสธร","ยะลา","ร้อยเอ็ด","ระนอง","ระยอง","ราชบุรี","ลพบุรี","ลำปาง","ลำพูน","เลย","ศรีสะเกษ","สกลนคร","สงขลา" ,"สตูล","สมุทรปราการ","สมุทรสงคราม","สมุทรสาคร","สระแก้ว","สระบุรี","สิงห์บุรี","สุโขทัย","สุพรรณบุรี","สุราษฎร์ธานี" ,"สุรินทร์","หนองคาย","หนองบัวลำภู","อยุธยา","อ่างทอง","อำนาจเจริญ","อุดรธานี","อุตรดิตถ์","อุทัยธานี","อุบลราชธานี").forEach(Provincename -> {
				provinceRepository.save(new Province(Provincename));
			});
			provinceRepository.findAll().forEach(System.out::println);

			Staff S1 = new Staff();
			S1.setStaffName("SomA");
			S1.setAge(20);
			S1.setAddress("123/2");
			S1.setPhone("081-2345678");
			S1.setStaffGender(genderRepository.findById(1));
			S1.setStaffProvince(provinceRepository.findById(13));
			S1.setStaffPosition(positionRepository.findById(3));
			staffRepository.save(S1);
			staffRepository.findAll().forEach(System.out::println);
		};
	}

}

