import java.util.*;

class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

class SocialMediaLinkedList {
    private User head;

    // Add a user
    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        newUser.next = head;
        head = newUser;
    }

    // Search for a user by ID
    public User searchUser(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Search for a user by name
    public User searchUser(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Add a friend connection
    public void addFriendConnection(int userId1, int userId2) {
        User user1 = searchUser(userId1);
        User user2 = searchUser(userId2);
        if (user1 != null && user2 != null) {
            if (!user1.friendIds.contains(userId2)) user1.friendIds.add(userId2);
            if (!user2.friendIds.contains(userId1)) user2.friendIds.add(userId1);
        } else {
            System.out.println("One or both users not found");
        }
    }

    // Remove a friend connection
    public void removeFriendConnection(int userId1, int userId2) {
        User user1 = searchUser(userId1);
        User user2 = searchUser(userId2);
        if (user1 != null && user2 != null) {
            user1.friendIds.remove((Integer) userId2);
            user2.friendIds.remove((Integer) userId1);
        } else {
            System.out.println("One or both users not found");
        }
    }

    // Find mutual friends
    public List<Integer> findMutualFriends(int userId1, int userId2) {
        User user1 = searchUser(userId1);
        User user2 = searchUser(userId2);
        List<Integer> mutualFriends = new ArrayList<>();
        if (user1 != null && user2 != null) {
            for (int friendId : user1.friendIds) {
                if (user2.friendIds.contains(friendId)) {
                    mutualFriends.add(friendId);
                }
            }
        }
        return mutualFriends;
    }

    // Display all friends of a user
    public void displayFriends(int userId) {
        User user = searchUser(userId);
        if (user != null) {
            System.out.println("Friends of " + user.name + ": " + user.friendIds);
        } else {
            System.out.println("User not found");
        }
    }

    // Count number of friends for each user
    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friends");
            temp = temp.next;
        }
    }
}

public class SocialMediaFriendConnections {
    public static void main(String[] args) {
        SocialMediaLinkedList network = new SocialMediaLinkedList();
        network.addUser(101, "Aditya", 22);
        network.addUser(102, "Yash", 23);
        network.addUser(103, "Anirudh", 20);
        
        network.addFriendConnection(101, 102);
        network.addFriendConnection(101, 103);
        network.addFriendConnection(102, 103);
        
        System.out.println("All friends:");
        network.displayFriends(101);
        network.displayFriends(102);
        network.displayFriends(103);
        
        System.out.println("\nMutual friends between 101 and 102: " + network.findMutualFriends(101, 102));
        
        System.out.println("\nRemoving friendship between 101 and 103");
        network.removeFriendConnection(101, 103);
        network.displayFriends(101);
        network.displayFriends(103);
        
        System.out.println("\nFriend counts:");
        network.countFriends();
    }
}
