package LLD.Splitwise.controller;

import LLD.Splitwise.models.Group;
import LLD.Splitwise.models.User;

import java.util.ArrayList;
import java.util.List;

public class GroupController {
    List<Group> groupList;

    public GroupController() {
        groupList = new ArrayList<>();
    }

    public void createNewGroup(String groupId, String groupName, User createByUser) {
        Group group = new Group();
        groupList.add(group);
    }
}
