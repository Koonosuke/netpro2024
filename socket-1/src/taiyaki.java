public class taiyaki
 {

	//================　属性　==================

	//外から見えない
	private			String	 中身;

	//外から見える
	public			String	 口の中身;

	//外から見えるけど変えられない
	public final	String	 焼き加減;

	//外から見えて、全てのたい焼きが共有している
	public static	String	 全国たい焼きキャッチフレーズ = "おいしいよ！";

	//----------------------------------------


	//================　機能　==================

	//新しいたい焼きを作る(newしたときに呼ばれる)
	public taiyaki(String 中身, String 焼き加減) {
		this.中身	 = 中身;
		this.焼き加減 = 焼き加減;
		return;
	}


	//しゃべる
	public void 自己紹介(){

		//口に何か入ってたら喋れない
		if(this.口の中身 != null){
			System.out.println("><((( '< 「モゴモゴ」");
			return;
		}

		System.out.print("><((( '< 「ぼくの中身は" + this.中身 + "で、焼き加減は" + this.焼き加減 + "だよ！」");
		System.out.println("「" + taiyaki.全国たい焼きキャッチフレーズ + "」");
		return;
	}


	//----------------------------------------

}
