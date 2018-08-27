package com.jhk.chatbot.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ChatbotController {

    // 키보드
    @RequestMapping(value = "/keyboard", method = RequestMethod.GET)
    public String keyboard() {

        System.out.println("/keyboard");

        JSONObject jobjBtn = new JSONObject();
        /*JSONArray jarray = new JSONArray();
        jarray.add("선택1");
        jarray.add("선택2");
        jarray.add("선택3");*/

        jobjBtn.put("type", "text");
        //jobjBtn.put("buttons", jarray);

        return jobjBtn.toJSONString();
    }

    // 메세지
    @RequestMapping(value = "/message", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public String message(@RequestBody JSONObject resObj) {

        System.out.println("/message");
        System.out.println(resObj.toJSONString());

        String content;
        content = (String) resObj.get("content");
        JSONObject jobjRes = new JSONObject();
        JSONObject jobjText = new JSONObject();
        JSONObject jobjBtn = new JSONObject();

        // 사용자 구현
        if (content.contains("안녕") || content.contains("하이") || content.contains("방가") || content.contains("ㅎㅇ")
                || content.contains("ㅎㅇㄹ") || content.contains("할룽")) {
            jobjText.put("text", "네 반가워요~ 안녕하세요~");
        } else if (content.contains("사랑")) {
            if (content.contains("제일 사랑하는 사람")) {
                jobjText.put("text", "너일까? 말까? ㅋㅋㅋㅋ");
            } else {
                jobjText.put("text", "나도 너무너무 사랑해");
            }
        } else if (content.contains("이름") || content.contains("누구")) {
            jobjText.put("text", "재현느님 입니다! 후훗");
        } else if (content.contains("잘자")) {
            jobjText.put("text", "꿈 속에서도 너를 볼꺼야");
        } else if (content.contains("졸려")) {
            jobjText.put("text", "졸리면 언능 세수하러 가용!");
        } else if (content.contains("시간") || content.contains("몇 시") || content.contains("몇시")) {
            jobjText.put("text", "섹시");
        } else if (content.contains("와우") || content.contains("까자") || content.contains("꽈자")
                ||content.contains("시누이") || content.contains("ㅅㄴㅇ") || content.contains("참견러")
                || content.contains("와우들")) {
            ArrayList<String> btnArray = new ArrayList();
            btnArray.add("와우");
            btnArray.add("까자");
            btnArray.add("시누이");
            btnArray.add("참견러");

            jobjBtn.put("type", "buttons");
            jobjBtn.put("buttons", btnArray);

            jobjText.put("text", "같이 한 뚝배기 깨러 가실래예~~????");

            jobjRes.put("keyboard", jobjBtn);
        } else {
            jobjText.put("text", "흠... 아직 지정해 두지 않은 말인걸.");
        }

        jobjRes.put("message", jobjText);
        System.out.println(jobjRes.toJSONString());

        return jobjRes.toJSONString();
    }
}
