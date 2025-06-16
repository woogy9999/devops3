package com.sist.web.vo;

import lombok.Data;

@Data
public class CampVO {
	private int cno;

    private String title;
    private String intro;
    private String poster;
    private String managesttus;
    private String hvofbgnde;
    private String hvofenddle;
    private String operpdcl;
    private String induty;
    private String lctcl;
    private String addr;
    private String donm;

    private int gnrlsiteco;
    private int autositeco;
    private int glampsiteco;
    private int caravsiteco;
    private int indvdlcaravsiteco;

    private String caravacmpnyat;
    private String trleracmpnyat;
    private String animalcmgcl;

    private int hit;
    private int fcount;
    private int lcount;
    private int rcount;

    private String mapx;
    private String mapy;

    private int price;
    private int operdecl;
}
