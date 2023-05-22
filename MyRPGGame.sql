/*
 Navicat Premium Data Transfer

 Source Server         : aidashboard
 Source Server Type    : MongoDB
 Source Server Version : 60005
 Source Host           : localhost:27017
 Source Schema         : MyRPGGame

 Target Server Type    : MongoDB
 Target Server Version : 60005
 File Encoding         : 65001

 Date: 22/05/2023 09:06:30
*/


// ----------------------------
// Collection structure for accounts
// ----------------------------
db.getCollection("accounts").drop();
db.createCollection("accounts");

// ----------------------------
// Documents of accounts
// ----------------------------
db.getCollection("accounts").insert([ {
    _id: ObjectId("6411c9d5c5bd296ed0a36939"),
    email: "huynhhothoty@gmail.com",
    password: "123456",
    roles: [
        "ROLE_ADMIN"
    ],
    trangThai: true,
    createdDate: ISODate("2023-03-15T13:36:21.931Z"),
    lastModifiedDate: ISODate("2023-03-15T13:36:21.931Z"),
    userID: "20110597-HuynhHoThoTy",
    accountName: "HuynhHoThoTy"
} ]);

// ----------------------------
// Collection structure for characters
// ----------------------------
db.getCollection("characters").drop();
db.createCollection("characters");

// ----------------------------
// Documents of characters
// ----------------------------
db.getCollection("characters").insert([ {
    _id: ObjectId("6469dca33c646f5afb93ad69"),
    name: "Thoty1",
    level: NumberInt("501"),
    charClass: {
        _id: ObjectId("6461dbcb7096a62e20c15a47"),
        name: "Warrior",
        weapon: "Heavy Mace",
        skill: "Rage Strike"
    },
    _class: "hcmute.myrpggame.entities.characterEntity"
} ]);
db.getCollection("characters").insert([ {
    _id: ObjectId("6469dcbb3c646f5afb93ad6a"),
    name: "Thoty2",
    level: NumberInt("7"),
    charClass: {
        _id: ObjectId("6461db8d7096a62e20c15a46"),
        name: "Warlock",
        weapon: "Orb",
        skill: "Blood sacrificed"
    },
    _class: "hcmute.myrpggame.entities.characterEntity"
} ]);
db.getCollection("characters").insert([ {
    _id: ObjectId("6469dcd13c646f5afb93ad6b"),
    name: "Thoty3",
    level: NumberInt("34"),
    charClass: {
        _id: ObjectId("6461dbcb7096a62e20c15a47"),
        name: "Warrior",
        weapon: "Heavy Mace",
        skill: "Rage Strike"
    },
    _class: "hcmute.myrpggame.entities.characterEntity"
} ]);
db.getCollection("characters").insert([ {
    _id: ObjectId("6469dcdd3c646f5afb93ad6c"),
    name: "Thoty4",
    level: NumberInt("50"),
    charClass: {
        _id: ObjectId("6461dbcb7096a62e20c15a47"),
        name: "Warrior",
        weapon: "Heavy Mace",
        skill: "Rage Strike"
    },
    _class: "hcmute.myrpggame.entities.characterEntity"
} ]);

// ----------------------------
// Collection structure for classes
// ----------------------------
db.getCollection("classes").drop();
db.createCollection("classes");

// ----------------------------
// Documents of classes
// ----------------------------
db.getCollection("classes").insert([ {
    _id: ObjectId("6461db8d7096a62e20c15a46"),
    name: "Warlock",
    weapon: "Orb",
    skill: "Blood sacrificed",
    _class: "hcmute.myrpggame.entities.classEntity"
} ]);
db.getCollection("classes").insert([ {
    _id: ObjectId("6461dbcb7096a62e20c15a47"),
    name: "Warrior",
    weapon: "Heavy Mace",
    skill: "Rage Strike",
    _class: "hcmute.myrpggame.entities.classEntity"
} ]);
db.getCollection("classes").insert([ {
    _id: ObjectId("6461dbdf7096a62e20c15a48"),
    name: "Priest",
    weapon: "Staff",
    skill: "Holy light",
    _class: "hcmute.myrpggame.entities.classEntity"
} ]);
db.getCollection("classes").insert([ {
    _id: ObjectId("6461dbec7096a62e20c15a49"),
    name: "Mage",
    weapon: "Staff",
    skill: "Fire ball",
    _class: "hcmute.myrpggame.entities.classEntity"
} ]);
db.getCollection("classes").insert([ {
    _id: ObjectId("6461dc217096a62e20c15a4a"),
    name: "Swordsman",
    weapon: "Dual sword",
    skill: "Double slash",
    _class: "hcmute.myrpggame.entities.classEntity"
} ]);
db.getCollection("classes").insert([ {
    _id: ObjectId("6461dc667096a62e20c15a4b"),
    name: "Tanker",
    weapon: "Shield",
    skill: "Provoke",
    _class: "hcmute.myrpggame.entities.classEntity"
} ]);

// ----------------------------
// Collection structure for monsters
// ----------------------------
db.getCollection("monsters").drop();
db.createCollection("monsters");

// ----------------------------
// Documents of monsters
// ----------------------------
db.getCollection("monsters").insert([ {
    _id: ObjectId("6461c8c04f41b81a509725af"),
    name: "Goblin",
    power: NumberInt("10"),
    skill: "Gang bully",
    _class: "hcmute.myrpggame.entities.monsterEntity"
} ]);
db.getCollection("monsters").insert([ {
    _id: ObjectId("6461c8d94f41b81a509725b0"),
    name: "Hobgoblin",
    power: NumberInt("23"),
    skill: "Lead another goblin",
    _class: "hcmute.myrpggame.entities.monsterEntity"
} ]);
db.getCollection("monsters").insert([ {
    _id: ObjectId("6461c9454f41b81a509725b1"),
    name: "Lizard",
    power: NumberInt("13"),
    skill: "Spear attack",
    _class: "hcmute.myrpggame.entities.monsterEntity"
} ]);
db.getCollection("monsters").insert([ {
    _id: ObjectId("6461cc757ca35b65a91bd2f8"),
    name: "Kobold",
    power: NumberInt("17"),
    skill: "Heavy slamp",
    _class: "hcmute.myrpggame.entities.monsterEntity"
} ]);

// ----------------------------
// Collection structure for quests
// ----------------------------
db.getCollection("quests").drop();
db.createCollection("quests");

// ----------------------------
// Documents of quests
// ----------------------------
db.getCollection("quests").insert([ {
    _id: ObjectId("6469f6cdc7ae0767dd6fd238"),
    targetMonster: {
        _id: ObjectId("6461c8c04f41b81a509725af"),
        name: "Goblin",
        power: NumberInt("10"),
        skill: "Gang bully"
    },
    quantity: NumberInt("5"),
    reward: "900 gold",
    hunter: {
        _id: ObjectId("6469dca33c646f5afb93ad69"),
        name: "Thoty1",
        level: NumberInt("501"),
        charClass: {
            _id: ObjectId("6461dbcb7096a62e20c15a47"),
            name: "Warrior",
            weapon: "Heavy Mace",
            skill: "Rage Strike"
        }
    },
    _class: "hcmute.myrpggame.entities.questEntity"
} ]);
db.getCollection("quests").insert([ {
    _id: ObjectId("6469f6eac7ae0767dd6fd239"),
    targetMonster: {
        _id: ObjectId("6461c8c04f41b81a509725af"),
        name: "Goblin",
        power: NumberInt("10"),
        skill: "Gang bully"
    },
    quantity: NumberInt("9"),
    reward: "skill scroll",
    hunter: {
        _id: ObjectId("6469dca33c646f5afb93ad69"),
        name: "Thoty1",
        level: NumberInt("501"),
        charClass: {
            _id: ObjectId("6461dbcb7096a62e20c15a47"),
            name: "Warrior",
            weapon: "Heavy Mace",
            skill: "Rage Strike"
        }
    },
    _class: "hcmute.myrpggame.entities.questEntity"
} ]);
db.getCollection("quests").insert([ {
    _id: ObjectId("6469f708c7ae0767dd6fd23a"),
    targetMonster: {
        _id: ObjectId("6461c9454f41b81a509725b1"),
        name: "Lizard",
        power: NumberInt("13"),
        skill: "Spear attack"
    },
    quantity: NumberInt("45"),
    reward: "skill scroll",
    hunter: {
        _id: ObjectId("6469dca33c646f5afb93ad69"),
        name: "Thoty1",
        level: NumberInt("501"),
        charClass: {
            _id: ObjectId("6461dbcb7096a62e20c15a47"),
            name: "Warrior",
            weapon: "Heavy Mace",
            skill: "Rage Strike"
        }
    },
    _class: "hcmute.myrpggame.entities.questEntity"
} ]);
