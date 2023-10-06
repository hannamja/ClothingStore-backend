package com.example.demo.dto;

import java.util.List;

import com.example.demo.entity.Binhluan;
import com.example.demo.entity.Chatlieu;
import com.example.demo.entity.CtKhuyenmai;
import com.example.demo.entity.CtMathang;
import com.example.demo.entity.Danhgia;
import com.example.demo.entity.Loaimh;
import com.example.demo.entity.Nhanhieu;

public class MathangDTO {
	private Integer mamh;
	private ChatlieuDTO chatlieuDTO;
	private LoaimhDTO loaimhDTO;
	private NhanhieuDTO nhanhieuDTO;
	private String tenmh;
	private String mota;
	private String trangthai;
	private String cachlam;
	private String phanloai;
	private Integer gia;
	private CtKhuyenmaiDTO chitietKhuyenmaiDTO;
	private List<HinhanhDTO> hinhanhDTOs;
	private List<ChitietMathangDTO> ctMathangs;
	private List<DanhgiaDTO> danhgias;
	private List<BinhluanDTO> binhluans;
	
	public MathangDTO(Integer mamh, String tenmh) {
		super();
		this.mamh = mamh;
		this.tenmh = tenmh;
	}

	
	
	public MathangDTO(Integer mamh, ChatlieuDTO chatlieuDTO, LoaimhDTO loaimhDTO, NhanhieuDTO nhanhieuDTO, String tenmh,
			String mota, String trangthai, String cachlam, String phanloai, Integer gia,
			CtKhuyenmaiDTO chitietKhuyenmaiDTO, List<HinhanhDTO> hinhanhDTOs, List<ChitietMathangDTO> ctMathangs,
			List<DanhgiaDTO> danhgias, List<BinhluanDTO> binhluans) {
		super();
		this.mamh = mamh;
		this.chatlieuDTO = chatlieuDTO;
		this.loaimhDTO = loaimhDTO;
		this.nhanhieuDTO = nhanhieuDTO;
		this.tenmh = tenmh;
		this.mota = mota;
		this.trangthai = trangthai;
		this.cachlam = cachlam;
		this.phanloai = phanloai;
		this.gia = gia;
		this.chitietKhuyenmaiDTO = chitietKhuyenmaiDTO;
		this.hinhanhDTOs = hinhanhDTOs;
		this.ctMathangs = ctMathangs;
		this.danhgias = danhgias;
		this.binhluans = binhluans;
	}



	public MathangDTO(Integer mamh, ChatlieuDTO chatlieuDTO, LoaimhDTO loaimhDTO, NhanhieuDTO nhanhieuDTO, String tenmh,
			String mota, String trangthai, String cachlam, String phanloai, Integer gia, List<HinhanhDTO> hinhanhDTOs,
			List<ChitietMathangDTO> ctMathangs) {
		super();
		this.mamh = mamh;
		this.chatlieuDTO = chatlieuDTO;
		this.loaimhDTO = loaimhDTO;
		this.nhanhieuDTO = nhanhieuDTO;
		this.tenmh = tenmh;
		this.mota = mota;
		this.trangthai = trangthai;
		this.cachlam = cachlam;
		this.phanloai = phanloai;
		this.gia = gia;
		this.hinhanhDTOs = hinhanhDTOs;
		this.ctMathangs = ctMathangs;
	}

	public MathangDTO() {
		super();
	}
	
	

	public CtKhuyenmaiDTO getChitietKhuyenmaiDTO() {
		return chitietKhuyenmaiDTO;
	}



	public void setChitietKhuyenmaiDTO(CtKhuyenmaiDTO chitietKhuyenmaiDTO) {
		this.chitietKhuyenmaiDTO = chitietKhuyenmaiDTO;
	}



	public List<DanhgiaDTO> getDanhgias() {
		return danhgias;
	}


	public void setDanhgias(List<DanhgiaDTO> danhgias) {
		this.danhgias = danhgias;
	}


	public List<BinhluanDTO> getBinhluans() {
		return binhluans;
	}


	public void setBinhluans(List<BinhluanDTO> binhluans) {
		this.binhluans = binhluans;
	}


	public List<ChitietMathangDTO> getCtMathangs() {
		return ctMathangs;
	}

	public void setCtMathangs(List<ChitietMathangDTO> ctMathangs) {
		this.ctMathangs = ctMathangs;
	}

	public List<HinhanhDTO> getHinhanhDTOs() {
		return hinhanhDTOs;
	}
	public void setHinhanhDTOs(List<HinhanhDTO> hinhanhDTOs) {
		this.hinhanhDTOs = hinhanhDTOs;
	}
	public Integer getGia() {
		return gia;
	}
	public void setGia(Integer gia) {
		this.gia = gia;
	}
	public Integer getMamh() {
		return mamh;
	}
	public void setMamh(Integer mamh) {
		this.mamh = mamh;
	}
	public ChatlieuDTO getChatlieuDTO() {
		return chatlieuDTO;
	}
	public void setChatlieuDTO(ChatlieuDTO chatlieuDTO) {
		this.chatlieuDTO = chatlieuDTO;
	}
	public LoaimhDTO getLoaimhDTO() {
		return loaimhDTO;
	}
	public void setLoaimhDTO(LoaimhDTO loaimhDTO) {
		this.loaimhDTO = loaimhDTO;
	}
	public NhanhieuDTO getNhanhieuDTO() {
		return nhanhieuDTO;
	}
	public void setNhanhieuDTO(NhanhieuDTO nhanhieuDTO) {
		this.nhanhieuDTO = nhanhieuDTO;
	}
	public String getTenmh() {
		return tenmh;
	}
	public void setTenmh(String tenmh) {
		this.tenmh = tenmh;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	public String getCachlam() {
		return cachlam;
	}
	public void setCachlam(String cachlam) {
		this.cachlam = cachlam;
	}
	public String getPhanloai() {
		return phanloai;
	}
	public void setPhanloai(String phanloai) {
		this.phanloai = phanloai;
	}
	
}
