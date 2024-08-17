package HOMEWORK;
//Word Class
public class Word {
    private String content;
    private int length;

    public Word(String content){
        this.content = content;
        length = content.length();
    }

    public String getContent() {
        return content;
    }

    public int getLength() {
        return length;
    }

    public String toString(){
        return content;
    }

    //It controls whether word's content equals to parameter which is obj.
    public boolean equals(Object obj){
        if(obj==null || getClass() != obj.getClass()){
            return false;
        }
        Word other = (Word) obj;
        return (getContent().equals(other.content));
    }
}
