package com.liyahong.testdriving.db;

import android.content.Context;

import com.liyahong.testdriving.bean.Questions;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by liyahong0327 on 2017/6/21.
 */

public class QuestionsReader {

    private  Document document;
    private List<Questions> questions =new ArrayList<>();

    public List<Questions> getQuestions() {
        return questions;
    }

    public QuestionsReader(Context context, int reid) {
        InputStream in =context.getResources().openRawResource(reid);
        parseInputStream(in);
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public QuestionsReader(InputStream in){
        parseInputStream(in);
    }

    private void parseInputStream(InputStream in) {
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(in);
            NodeList questionNodeList = document.getElementsByTagName("question");
            Node questionNode;
            for (int i = 0; i < questionNodeList.getLength(); i++) {
                questionNode=questionNodeList.item(i);
                NodeList childNodes = questionNode.getChildNodes();
                Node childNode;
                Map<String,String> childrenMap =new HashMap<>();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    childNode=childNodes.item(j);
                    if (!childNode.getNodeName().equals("#text")){

                        childrenMap.put(childNode.getNodeName(),childNode.getTextContent().trim());
                    }
                }
                questions.add(new Questions(
                        childrenMap.get("title"),
                        childrenMap.get("a"),
                        childrenMap.get("b"),
                        childrenMap.get("c"),
                        childrenMap.get("d"),
                        childrenMap.get("answer"),
                        childrenMap.get("type"),
                        childrenMap.get("description")));
            }

        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }
}
