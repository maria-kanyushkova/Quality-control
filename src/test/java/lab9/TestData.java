package lab9;

import org.json.JSONObject;

class TestData {

    private static JSONObject createJSONObject() {
        return new JSONObject();
    }

    private static JSONObject getDefaultJSONObject() {
        JSONObject object = createJSONObject();
        object.put("title", "my title");
        object.put("content", "Content");
        object.put("keywords", "Keywords");
        object.put("description", "Description");
        return object;
    }

    static JSONObject getJsonObjectExistsAlias() {
        JSONObject object = getDefaultJSONObject();
        object.put("alias", "my-title-9");
        object.put("category_id", 3);
        object.put("price", 99);
        object.put("old_price", -30);
        object.put("status", 1);
        object.put("hit", 1);
        return object;
    }

    static JSONObject getJsonObjectNegativePrice() {
        JSONObject object = getDefaultJSONObject();
        object.put("category_id", 4);
        object.put("price", -1024);
        object.put("old_price", -1100);
        object.put("status", 1);
        object.put("hit", 1);
        return object;
    }

    static JSONObject getJsonObjectZeroPrice() {
        JSONObject object = getDefaultJSONObject();
        object.put("category_id", 4);
        object.put("price", 0);
        object.put("old_price", 234);
        object.put("status", 1);
        object.put("hit", 1);
        return object;
    }

    static JSONObject getJsonObjectPositivePrice() {
        JSONObject object = getDefaultJSONObject();
        object.put("category_id", 4);
        object.put("price", 424);
        object.put("old_price", 679);
        object.put("status", 1);
        object.put("hit", 1);
        return object;
    }

    static JSONObject getJsonObjectOverflowPrice() {
        JSONObject object = getDefaultJSONObject();
        object.put("category_id", 4);
        object.put("price", Integer.MAX_VALUE + 10);
        object.put("old_price", 679);
        object.put("status", 1);
        object.put("hit", 1);
        return object;
    }

    static JSONObject getJsonObjectMinCategoryId() {
        JSONObject object = getDefaultJSONObject();
        object.put("category_id", 1);
        object.put("price", 200);
        object.put("old_price", 400);
        object.put("status", 1);
        object.put("hit", 1);
        return object;
    }

    static JSONObject getJsonObjectStatusZero() {
        JSONObject object = getDefaultJSONObject();
        object.put("category_id", 8);
        object.put("price", 5321);
        object.put("old_price", 0);
        object.put("status", 0);
        object.put("hit", 1);
        return object;
    }

    static JSONObject getJsonObjectEmptyTitle() {
        JSONObject object = getDefaultJSONObject();

        object.remove("title");
        object.put("title", "");

        object.put("category_id", 6);
        object.put("price", 902);
        object.put("old_price", 579);
        object.put("status", 1);
        object.put("hit", 1);
        return object;
    }

    static JSONObject getChangeValueObject(JSONObject object, Object value) {
        object.put("id", value);
        return object;
    }
}