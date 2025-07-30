package com.studys.button_backend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

interface Observer {
   public   Boolean update(Boolean sendMessage);
}