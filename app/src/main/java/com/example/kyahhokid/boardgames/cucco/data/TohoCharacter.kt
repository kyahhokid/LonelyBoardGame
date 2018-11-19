package com.example.kyahhokid.boardgames.cucco.data

/**
 * キャラクター情報種別
 */
enum class TohoCharacter(private val faceName: String) {
    // 主人公
    reimu("reimu_normal_face"),
    marisa("marisa_normal_face"),
    // 東方紅魔郷
    rumia("rumia_normal_face"),
    daiyousei("daiyousei_normal_face"),
    cirno("cirno_normal_face"),
    merin("merin_normal_face"),
    koakuma("koakuma_normal_face"),
    patchouli("patchouli_normal_face"),
    sakuya("sakuya_normal_face"),
    remilia("remilia_normal_face"),
    flandre("flandre_normal_face"),
    // 東方地霊殿
    kisume("kisume_normal_face"),
    yamame("yamame_normal_face"),
    parsee("parsee_normal_face"),
    yugi("yugi_normal_face"),
    satori("satori_normal_face"),
    rin("rin_normal_face"),
    utsuho("utsuho_normal_face"),
    koishi("koishi_normal_face");

    /**
     * キャラクターの表情のファイル名を返す。
     */
    fun getFaceName(): String {
        return faceName
    }
}