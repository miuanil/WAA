// import axios from "axios";
// import { useRef } from "react";
import './AddPost.css';

const AddPost = (props) => {

    // const newPostForm = useRef();

    // const PostHandler = () => {
    //     const form = newPostForm.current;
    //     const data = {
    //         title: form['title'].value,
    //         author: form['author'].value,
    //         content: form['content'].value,
    //     };

    //     axios.post('posts', data)
    //         .then(data => {
    //             console.log('Success', data);
    //         })
    //         .catch(error => {
    //             console.error('Error:', error);
    //         })

    //     console.log(data);
    // }

    return (
        <div className="NewPost">

            <h1>Add a Post</h1>

            {/* <form ref={newPostForm}> */}
                <label>Post Title</label>
                <input type="text"
                    label={'title'}
                    name={'title'}
                    value={props.title || ''}
                    onChange={props.onChange}
                />

                <label>Author</label>
                <input type="text"
                    label={'author'}
                    name={'author'}
                    value={props.author || ''}
                    onChange={props.onChange}
                />

                <label>Content</label>
                <input type="text"
                    label={'content'}
                    name={'content'}
                    value={props.content || ''}
                    onChange={props.onChange}
                />
            {/* </form> */}

            <button onClick={props.addButtonClicked}>Add Post </button>
            {/* <button onClick={PostHandler}>Add Post </button> */}
        </div>
    )
}

export default AddPost;