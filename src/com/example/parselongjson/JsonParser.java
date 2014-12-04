package com.example.parselongjson;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {
	
	private int count;
	private ArrayList<Item> items = new ArrayList<Item>();
	
	public JsonParser(String json) {
		
		try {
			
			JSONObject jObject = new JSONObject(json);
			JSONObject responseJObject = jObject.getJSONObject("response");
			
			count = responseJObject.getInt("count");
			
			JSONArray jArray = responseJObject.getJSONArray("items");
			for (int i=0; i < jArray.length(); i++) {
				
				JSONObject j = jArray.getJSONObject(i);
				
				Item item = new Item();
				
				item.setDate(j.getInt("date") + "");
				item.setFrom_id(j.getInt("from_id") + "");
				item.setId(j.getInt("id") + "");
				item.setOwner_id(j.getInt("owner_id") + "");
				item.setPost_type(j.getString("post_type"));
				item.setText(j.getString("text"));
				
				item.setComments_count(j.getJSONObject("comments").getInt("count") + "");
				item.setLikes_count(j.getJSONObject("likes").getInt("count") + "");
				item.setReposts_count(j.getJSONObject("reposts").getInt("count") + "");
				
				JSONArray attachmentsJArray = j.getJSONArray("attachments");
				for (int k=0; k < attachmentsJArray.length(); k++) {
					
					JSONObject attJson = attachmentsJArray.getJSONObject(k);
					
					Attachment attachment = null;
					if (attJson.getString("type").equals("photo"))
						attachment = new PhotoAttachment();
					else
					{}
					
					attachment.setType(attJson.getString("type"));
					attJson = attJson.getJSONObject(attachment.getType());
					
					try {
						attachment.setAccess_key(attJson.getString("access_key"));
					} catch (Exception e) {
					}
					
					attachment.setDate(attJson.getInt("date") + "");
					attachment.setId(attJson.getInt("id") + "");
					attachment.setOwner_id(attJson.getInt("owner_id") + "");
					attachment.setText(attJson.getString("text"));
					
					if (attachment.getType().equals("photo")) {
						PhotoAttachment photo = (PhotoAttachment)attachment;
						
						photo.setPhoto_130(attJson.getString("photo_130"));
						photo.setPhoto_604(attJson.getString("photo_604"));
						photo.setPhoto_75(attJson.getString("photo_75"));
						photo.setPhoto_807(attJson.getString("photo_807"));
						
						photo.setAlbum_id(attJson.getInt("album_id") + "");
						photo.setHeight(attJson.getInt("height") + "");
						photo.setWidth(attJson.getInt("width") + "");
						
					} else {
						// other type of att..
					}
					
					item.getAttachments().add(attachment);
				}
				items.add(item);
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		String itemsString = "";
		for (int i=0;i<getItems().size();i++) {
			itemsString += "\n-------\n" + getItems().get(i).toString();
		}
		return "JsonParser [items=" + itemsString + "]";
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
