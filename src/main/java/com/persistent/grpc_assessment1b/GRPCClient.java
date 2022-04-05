package com.persistent.grpc_assessment1b;

import com.persistent.grpc_assessment1b.User.APIResponse;
import com.persistent.grpc_assessment1b.User.LoginRequest;
import com.persistent.grpc_assessment1b.userGrpc.userBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GRPCClient {
	public static void main(String[] args) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
		
		userBlockingStub userStub = userGrpc.newBlockingStub(channel);
		LoginRequest loginRequest = LoginRequest.newBuilder().setUsername("Test1234").setPassword("Test123").build();
		
		APIResponse apiResponse = userStub.login(loginRequest);
		System.out.println(apiResponse.getResponsemessage());
	}
}
