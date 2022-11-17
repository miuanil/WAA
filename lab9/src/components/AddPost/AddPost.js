import axios from "axios";
import { useRef } from "react";
import './AddPost.css';

const AddPost = () => {

    const newPostForm = useRef();

    const PostHandler = () => {
        const form = newPostForm.current;
        const data = {
            title: form['title'].value,
            author: form['author'].value,
            content: form['content'].value,
        };

        axios.post('posts', data)
            .then(data => {
                console.log('Success', data);
            })
            .catch(error => {
                console.error('Error:', error);
            })
    }

    return (
        <div className="NewPost">

            <h1>Add a Post</h1>

            <form ref={newPostForm}>
                <label>Post Title</label>
                <input type="text"
                    label={'title'}
                    name={'title'}
                />

                <label>Author</label>
                <input type="text"
                    label={'author'}
                    name={'author'}
                />

                <label>Content</label>
                <input type="text"
                    label={'content'}
                    name={'content'}
                />
            </form>

            <button onClick={PostHandler}>Add Post </button>
        </div>
    )
}

export default AddPost;