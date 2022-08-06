/**
 * https://leetcode.com/problems/design-a-text-editor/
 *
 * Output:
 * ------
 * 4
 * etpractice
 * leet
 * 4
 * 
 * practi
 */

public class TextEditor {

    int cursorPos;
    StringBuilder sb;

    public TextEditor() {
        cursorPos = 0;
        sb = new StringBuilder();
    }

    public void addText(String text) {
    	sb.insert(this.cursorPos, text);
    	this.cursorPos += text.length();
    }

    public int deleteText(int k) {
    	int countDeleted = 0;
        if (this.cursorPos > k-1) {
        	sb.delete(this.cursorPos-k, this.cursorPos);
        	this.cursorPos -= k;
        	countDeleted = k;
        } else {
        	countDeleted = this.cursorPos;
        	sb.delete(0, countDeleted);
        	this.cursorPos = 0;
        }
        return countDeleted;
    }

    public String cursorLeft(int k) {
    	this.cursorPos -= k;
    	if (this.cursorPos < 0) {
    		this.cursorPos = 0;
    	}
        String str = "";
        if (this.cursorPos >= 10) {
        	str = sb.substring(this.cursorPos-10, this.cursorPos);
        } else {
        	str = sb.substring(0, this.cursorPos);
        }
        return str;
    }

    public String cursorRight(int k) {
    	this.cursorPos += k;
    	if (this.cursorPos > sb.length()) {
    		this.cursorPos = sb.length();
    	}
        String str = "";
        if (this.cursorPos >= 10) {
        	str = sb.substring(this.cursorPos-10, this.cursorPos);
        } else {
        	str = sb.substring(0, this.cursorPos);
        }
        return str;
    }

    public static void main(String[] args) {
        TextEditor obj = new TextEditor();
        obj.addText("leetcode");
        System.out.println(obj.deleteText(4));
        obj.addText("practice");
        System.out.println(obj.cursorRight(3));
        System.out.println(obj.cursorLeft(8));
        System.out.println(obj.deleteText(10));
        System.out.println(obj.cursorLeft(2));
        System.out.println(obj.cursorRight(6));
    }

}

