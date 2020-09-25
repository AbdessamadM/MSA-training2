package com.mclientui.proxies;

import com.mclientui.bean.ExpeditionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "zuul-server")
@RibbonClient(name="microservice-expedition")
public interface MicroserviceExpeditionProxy {

    @PostMapping(value = "/microservice-expedition/Expedition")
    ResponseEntity<ExpeditionBean> nouvelleExpeditiion(@RequestBody ExpeditionBean expeditionBean);

    @GetMapping( value = "/microservice-expedition/Expedition/{id}")
    ExpeditionBean recupererUneExpedition(@PathVariable("id") int id);
}
