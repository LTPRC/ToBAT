package com.github.ltprc.algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 字典树的节点类型
 */
class TrieNode{
    char ch;
    int freqs;  //记录单词出现次数
    Map<Character, TrieNode> nodeMap;

    public TrieNode(char ch, int freqs, Map<Character, TrieNode> nodeMap) {
        this.ch = ch;
        this.freqs = freqs;
        this.nodeMap = nodeMap;
    }
}

/**
 * 描述: 字典树的实现
 *
 */
public class TrieTree {
    private TrieNode root;

    public TrieTree(){
        root = new TrieNode('\u0000', 0, new HashMap<Character, TrieNode>());
    }

    /**
     * 查询str字符串是否存在，不存在返回0，存在返回该字符串的个数
     * @param str
     * @return
     */
    public int query(String str){
        TrieNode cur=root;
        if(root==null){
            return 0;
        }
        for(int i=0;i<str.length();i++){
            TrieNode child=cur.nodeMap.get(str.charAt(i));
            if(child==null){
                return 0;
            }else {
                cur = child;
            }
        }
        return cur.freqs;
    }

    /**
    *添加单词
    */
    public void add(String str){
        TrieNode cur=root;
        if(root==null){
            return;
        }
        for(int i=0;i<str.length();i++){
            TrieNode child=cur.nodeMap.get(str.charAt(i));
            if(child==null){
                TrieNode node=new TrieNode(str.charAt(i),0,new HashMap<Character, TrieNode>());
                cur.nodeMap.put(str.charAt(i),node);
                cur=cur.nodeMap.get(str.charAt(i));
            }else{
                cur=child;
            }
        }
       cur.freqs++;
    }

    /**
     * 判断str是否存在
     * @param str
     * @return
     */
    public boolean search(String str){
        TrieNode cur=root;
        if(root==null){
            return false;
        }
        for(int i=0;i<str.length();i++){
            TrieNode child=cur.nodeMap.get(str.charAt(i));
            if(child==null){
                return false;
            }else {
                cur = child;
            }
        }
        return true;
    }

    /**
     * 删除str字符串
     * 三种情况
     *
     */
    public void remove(String str) {
        if(search(str)==false){
            return;
        }
        TrieNode cur=root;
        TrieNode delPreNode=root;
        char delch=str.charAt(0);
        for(int i=0;i<str.length();i++){
            TrieNode child=cur.nodeMap.get(str.charAt(i));
            if(child.nodeMap==null){  //后面没有结点
              return;
            }else if(i<str.length()-1 && (child.nodeMap.get(str.charAt(i+1))!=null) && child.nodeMap.size()>0){
                delPreNode=child;
                delch=str.charAt(i+1);
            }
            cur=child;
        }
        if(cur.nodeMap.size()>0){
            cur.freqs=0;
        }else{
            cur.nodeMap.remove(delch);
        }
    }

    /**
     * 打印最长公共前缀
     */
    public String getLongestPrefix() {
        StringBuilder sb = new StringBuilder();
        TrieNode cur = root;
        while (true) {
            if (cur.freqs > 0 || cur.nodeMap.isEmpty() || cur.nodeMap.size() > 1) {
                break;
            }
            Set<Entry<Character, TrieNode>> set = cur.nodeMap.entrySet();
            Iterator itr = set.iterator();
            Entry<Character, TrieNode> entry = (Entry<Character, TrieNode>)itr.next();
            cur = entry.getValue();
            sb.append(cur.ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TrieTree trieTree = new TrieTree();
        trieTree.add("super");
        trieTree.add("superman");
        trieTree.add("superb");
        System.out.println(trieTree.getLongestPrefix());
    }
}
