import React,{useEffect} from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { addAllPost, selectPost } from '../public/src/features/postSlice';
import Post from './Post'
import axios from "axios";
const Posts = () => {
  const FACEBOOK_CLONE_ENDPOINT="http://localhost:8088/api/v1/posts"
  const dispatch=useDispatch();
  const posts=useSelector(selectPost);
  useEffect(()=>{
    const fetchData=()=>{
      const response=axios.get(FACEBOOK_CLONE_ENDPOINT)
      .then((response)=>{
        dispatch(addAllPost(response.data));
      })
    }
    fetchData()
  },[])
  return (
    <div>{posts.map((post)=>(
      <Post post={post} key={post.id}/>
    ))}</div>
   
  )
}

export default Posts
