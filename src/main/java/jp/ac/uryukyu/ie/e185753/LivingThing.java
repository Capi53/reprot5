package jp.ac.uryukyu.ie.e185753;

/**
 * キャラ設定クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * ReCreated by e185753 on 2018/12/17.
 */
public class LivingThing{
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;





    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name 対象の名
     * @param maximumHP 対象のHP
     * @param attack 対象の攻撃力
     */
    public LivingThing(String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * getterメソッドと同等。生死をboolean表現しているためメソッド名をisDead()とした。
     * @return boolean
     */
    public boolean isDead() {
        return dead;
    }

    /**
     * privateなフィールド変数である名前を参照
     * @return name
     */
    public String getName(){
        return name;
    }
    /**
     * privateなフィールド変数であるhitPointを参照
     * @return hitPoint
     */
    public int getHitPoint(){
        return hitPoint;
    }
    /**
     * privateなフィールド変数であるhitPointを更新
     */
    public void setHitPoint(int num){
        this.hitPoint = num;
    }
    /**
     * privateなフィールド変数であるdeadを更新
     */
    public void setDead(boolean bool){
        this.dead = bool;
    }
    /**
     * 与えるダメージを決めて、攻撃した処理を表示するメソッド。
     * wounded()を動かす。
     */
    public void attack(LivingThing opponent) {
        if (!isDead()) {
            int damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }

    }
}
