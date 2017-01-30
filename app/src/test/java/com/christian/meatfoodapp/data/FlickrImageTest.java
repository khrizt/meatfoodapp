package com.christian.meatfoodapp.data;

import com.christian.meatfoodapp.net.FlickrParse;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FlickrImageTest {

    private String id = "fakeId";
    private String farm = "farm1";
    private String server = "server1";
    private String owner = "owner1";
    private String title = "title";
    private String secret = "secret1";
    private boolean isPublic = true;
    private boolean isFriend = true;
    private boolean isFamily = true;

    protected JSONObject getDefinitionJsonObject() {
        return Mockito.mock(JSONObject.class);
    }

    protected JSONObject getCorrectFlickrImageJsonObject() {
        JSONObject flickrImage = getDefinitionJsonObject();
        try {
            when(flickrImage.has("id")).thenReturn(true);
            when(flickrImage.get("id")).thenReturn(id);
            when(flickrImage.getString("id")).thenReturn(id);
            when(flickrImage.has("farm")).thenReturn(true);
            when(flickrImage.get("farm")).thenReturn(farm);
            when(flickrImage.getString("farm")).thenReturn(farm);
            when(flickrImage.has("server")).thenReturn(true);
            when(flickrImage.get("server")).thenReturn(server);
            when(flickrImage.getString("server")).thenReturn(server);
            when(flickrImage.has("owner")).thenReturn(true);
            when(flickrImage.get("owner")).thenReturn(owner);
            when(flickrImage.getString("owner")).thenReturn(owner);
            when(flickrImage.has("title")).thenReturn(true);
            when(flickrImage.get("title")).thenReturn(title);
            when(flickrImage.getString("title")).thenReturn(title);
            when(flickrImage.has("secret")).thenReturn(true);
            when(flickrImage.get("secret")).thenReturn(secret);
            when(flickrImage.getString("secret")).thenReturn(secret);

            when(flickrImage.has("isPublic")).thenReturn(true);
            when(flickrImage.get("isPublic")).thenReturn(isPublic ? 1 : 0);
            when(flickrImage.getInt("isPublic")).thenReturn(isPublic ? 1 : 0);
            when(flickrImage.has("isFriend")).thenReturn(true);
            when(flickrImage.get("isFriend")).thenReturn(isFriend ? 1 : 0);
            when(flickrImage.getInt("isFriend")).thenReturn(isFriend ? 1 : 0);
            when(flickrImage.has("isFamily")).thenReturn(true);
            when(flickrImage.get("isFamily")).thenReturn(isFamily ? 1 : 0);
            when(flickrImage.getInt("isFamily")).thenReturn(isFamily ? 1 : 0);
        } catch (JSONException e) {
            assertFalse("Parse method throwed an unexpected exception: "+e.getMessage(), true);
        }

        return flickrImage;
    }

    @Test
    public void testParseFlickrImageCorrect() {
        JSONObject object = getCorrectFlickrImageJsonObject();
        FlickrImage flickrImage = FlickrImage.parse(object);

        assertEquals(id, flickrImage.getId());
        assertEquals(server, flickrImage.getServer());
        assertEquals(secret, flickrImage.getSecret());
        assertEquals(farm, flickrImage.getFarm());
        assertEquals(owner, flickrImage.getOwner());
        assertEquals(title, flickrImage.getTitle());
        assertTrue(flickrImage.isPublic());
        assertTrue(flickrImage.isFriend());
        assertTrue(flickrImage.isFamily());
    }
}
