package com.cbl.app.account.controller;

import com.cbl.app.account.consumer.WikiMediaStreamConsumer;
import com.cbl.app.account.util.UrlUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UrlUtility.WIKIMEDIA_CONTROLLER)
@RequiredArgsConstructor
public class WikiMediaController {
    private final WikiMediaStreamConsumer wikiMediaStreamConsumer;

    @GetMapping
    public void startPublishing() {
        wikiMediaStreamConsumer.consumeStreamAndPublish();
    }

}
