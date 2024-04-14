package com.skoolio.PaymentService.PaymentService.implementations;

import com.skoolio.PaymentService.PaymentService.services.OrderService;
import com.skoolio.PaymentService.PaymentService.utils.Constants;
import com.skoolio.PaymentService.PaymentService.utils.Utils;
import okhttp3.*;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public JSONObject createOrder(Integer amount,
                                  String studentId,
                                  String classId,
                                  String receipt,
                                  Long feeMonthEpoch) throws Exception {
        try {
            // Create OkHttpClient instance
            OkHttpClient client = new OkHttpClient();

            // Create JSON media type
            MediaType JSON = MediaType.parse("application/json; charset=utf-8");
            JSONObject orderRequest = new JSONObject();
            orderRequest.put("amount", amount*100);
            orderRequest.put("currency", "INR");
            orderRequest.put("receipt", receipt);
            JSONObject notes = new JSONObject();
            notes.put("studentId", studentId);
            notes.put("classId", classId);
            notes.put("For MM/YYYY", Utils.convertEpochToMonthYear(feeMonthEpoch));
            orderRequest.put("notes", notes);

            RequestBody body = RequestBody.create(String.valueOf(orderRequest), JSON);
            String credentials = Constants.keyId + ":" + Constants.keySecret;
            String basicAuth = "Basic " + Base64.getEncoder().encodeToString(credentials.getBytes());
            Request request = new Request.Builder()
                    .url("https://api.razorpay.com/v1/orders")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization", basicAuth)
                    .build();
            Response response = client.newCall(request).execute();
            String responseString = response.body().string();
            JSONObject jsonResonse = new JSONObject(responseString);
            return jsonResonse;
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
