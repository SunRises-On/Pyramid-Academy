public class Sprite {
    private boolean isVisible;
    private char image;
    protected int x;
    protected int y;
    protected boolean isDead;
    public Sprite(){
        isVisible = true;
    }
    public void die(){
        isVisible = false;
    }
    public boolean getIsVisible(){
        return isVisible;
    }
    protected void setIsVisible(boolean newVisible){
        this.isVisible = isVisible;
    }
    public void setImage  (char newImage){
        this.image = newImage;
    }
    public char getImage (){
        return image;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getY(){
        return y;
    }
    public int getX(){
        return x;
    }
    public void setDead(boolean isDead){
        this.isDead = isDead;
    }
    public boolean getIsDead(){
        return isDead;
    }
}
