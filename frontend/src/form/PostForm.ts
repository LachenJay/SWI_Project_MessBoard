import {UserModel} from "../model/UserModel";

export class PostForm {
    title: string;
    text: string;
    tag: string;
    user: string;

    constructor(title: string, text: string, tag: string, user: string) {
        this.title = title;
        this.text = text;
        this.tag = tag;
        //this.user = user; //????
        this.user = localStorage.getItem("user"); //TODO: well ok, but make it so you can't post if you aren't logged in
    }
}