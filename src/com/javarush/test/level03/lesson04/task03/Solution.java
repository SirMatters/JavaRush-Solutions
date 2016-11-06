package com.javarush.test.level03.lesson04.task03;

/* StarCraft
Создать 10 зергов, 5 протосов и 12 терран.
Дать им всем уникальные имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Zerg a = new Zerg();
        a.name = "a";
        Zerg b = new Zerg();
        b.name = "b";
        Zerg c = new Zerg();
        c.name = "c";
        Zerg d = new Zerg();
        d.name = "d";
        Zerg e= new Zerg();
        e.name = "e";
        Zerg f = new Zerg();
        f.name = "f";
        Zerg g = new Zerg();
        g.name = "g";
        Zerg h = new Zerg();
        h.name = "h";
        Zerg i = new Zerg();
        i.name = "i";
        Zerg j = new Zerg();
        j.name = "j";

        Protos aa = new Protos();
        aa.name = "aa";
        Protos bb = new Protos();
        bb.name = "bb";
        Protos cc = new Protos();
        cc.name = "cc";
        Protos dd = new Protos();
        dd.name = "dd";
        Protos ee = new Protos();
        ee.name = "ee";

        Terran aaa = new Terran();
        aaa.name = "Johny";
        Terran bbb = new Terran();
        bbb.name = "Delata";
        Terran ccc = new Terran();
        ccc.name = "ccc";
        Terran ddd = new Terran();
        ddd.name = "ddd";
        Terran eee = new Terran();
        eee.name = "eee";
        Terran fff = new Terran();
        fff.name = "fff";
        Terran jjj = new Terran();
        jjj.name = "jjj";
        Terran kkk = new Terran();
        kkk.name = "kkk";
        Terran lll = new Terran();
        lll.name = "lll";
        Terran mmm = new Terran();
        mmm.name = "mmm";
        Terran ooo = new Terran();
        ooo.name = "ooo";
        Terran yyy = new Terran();
        yyy.name = "yyy";

    }

    public static class Zerg
    {
        public String name;
    }

    public static class Protos
    {
        public String name;
    }

    public static class Terran
    {
        public String name;
    }
}